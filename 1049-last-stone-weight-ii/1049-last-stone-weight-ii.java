class Solution {
    public int lastStoneWeightII(int[] stones) {

        int total = 0;

        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;

        // dp[j] = maximum sum we can make using sum <= j
        int[] dp = new int[target + 1];

        for (int stone : stones) {

            // Reverse traversal because each stone can be used only once
            for (int j = target; j >= stone; j--) {

                dp[j] = Math.max(
                    dp[j],
                    dp[j - stone] + stone
                );
            }
        }

        return total - 2 * dp[target];
    }
}