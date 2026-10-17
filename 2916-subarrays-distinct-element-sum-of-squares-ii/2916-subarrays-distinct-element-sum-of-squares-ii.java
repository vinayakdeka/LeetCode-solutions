
import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree tree = new SegmentTree(n);
        int[] lastSeen = new int[100001];
        Arrays.fill(lastSeen, -1);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int left = lastSeen[nums[i]] + 1;

            // Increase distinct counts for all affected subarrays
            tree.update(left, i, 1);

            lastSeen[nums[i]] = i;

            // Add squares for all subarrays ending at i
            answer = (answer + tree.squareSum()) % MOD;
        }

        return (int) answer;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] squareSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int left, int right, long val) {
            long len = right - left + 1L;

            // (x + val)^2 = x^2 + 2*x*val + val^2
            squareSum[node] =
                (squareSum[node]
                + 2L * val * sum[node] % MOD
                + val * val % MOD * len % MOD) % MOD;

            sum[node] = (sum[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void pushDown(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;

            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);

            lazy[node] = 0;
        }

        void pull(int node) {
            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            squareSum[node] =
                (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
        }

        void update(int ql, int qr, long val) {
            if (ql > qr) return;
            update(1, 0, n - 1, ql, qr, val);
        }

        void update(int node, int left, int right,
                    int ql, int qr, long val) {

            if (ql <= left && right <= qr) {
                apply(node, left, right, val);
                return;
            }

            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            if (ql <= mid) {
                update(node * 2, left, mid, ql, qr, val);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, right, ql, qr, val);
            }

            pull(node);
        }

        long squareSum() {
            return squareSum[1];
        }
    }
}
