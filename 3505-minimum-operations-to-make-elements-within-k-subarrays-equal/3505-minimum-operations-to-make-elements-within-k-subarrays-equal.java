
import java.util.*;

class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        void add(int num) {

            if (left.isEmpty() || num <= left.lastKey()) {
                left.merge(num, 1, Integer::sum);
                leftSize++;
                leftSum += num;
            } else {
                right.merge(num, 1, Integer::sum);
                rightSize++;
                rightSum += num;
            }

            balance();
        }

        void remove(int num) {

            if (left.containsKey(num)) {
                removeFrom(left, num);
                leftSize--;
                leftSum -= num;
            } else {
                removeFrom(right, num);
                rightSize--;
                rightSum -= num;
            }

            balance();
        }

        void removeFrom(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);

            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {

            while (leftSize > rightSize + 1) {

                int val = left.lastKey();

                removeFrom(left, val);
                leftSize--;
                leftSum -= val;

                right.merge(val, 1, Integer::sum);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < rightSize) {

                int val = right.firstKey();

                removeFrom(right, val);
                rightSize--;
                rightSum -= val;

                left.merge(val, 1, Integer::sum);
                leftSize++;
                leftSum += val;
            }
        }

        long getCost() {

            long median = left.lastKey();

            return median * leftSize - leftSum
                    + rightSum - median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate the cost of every window
        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++) {

            window.add(nums[i]);

            if (i >= x) {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }

        // Step 2: Dynamic Programming

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Choice 1: Skip current element
                dp[i][j] = dp[i - 1][j];

                // Choice 2: Select a window of size x
                if (i >= x && dp[i - x][j - 1] != INF) {

                    long pick = cost[i - x] + dp[i - x][j - 1];

                    dp[i][j] = Math.min(dp[i][j], pick);
                }
            }
        }

        return dp[n][k];
    }
}
