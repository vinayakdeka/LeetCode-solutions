
class Solution {
    public int minOperations(int k) {
        if (k == 1) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(k); i++) {
            int operations = i - 1 + (k - 1) / i;
            ans = Math.min(ans, operations);
        }

        return ans;
    }
}
