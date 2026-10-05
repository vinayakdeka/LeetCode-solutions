class Solution
{
    long[][] dp = new long[1000][1000];

    long helper(String str, int i, int j){

        if(i > j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int mod = (int)Math.pow(10,9) + 7;

        if(i == j)
            return dp[i][j] = 1;

        else if(str.charAt(i) == str.charAt(j)){

            int low = i + 1;
            int high = j - 1;

            // Find first same character from left
            while(low <= high && str.charAt(low) != str.charAt(i)){
                low++;
            }

            // Find last same character from right
            while(low <= high && str.charAt(high) != str.charAt(i)){
                high--;
            }

            if(low > high){

                // No same character inside
                return dp[i][j] =
                    (2 * helper(str, i + 1, j - 1) + 2) % mod;

            }
            else if(low == high){

                // Exactly one same character inside
                return dp[i][j] =
                    (2 * helper(str, i + 1, j - 1) + 1) % mod;

            }
            else{

                // Two or more same characters inside
                return dp[i][j] =
                    (2 * helper(str, i + 1, j - 1)
                    - helper(str, low + 1, high - 1)
                    + mod) % mod;
            }
        }

        else{

            return dp[i][j] =
                (mod
                + helper(str, i + 1, j)
                + helper(str, i, j - 1)
                - helper(str, i + 1, j - 1)) % mod;
        }
    }

    public int countPalindromicSubsequences(String s)
    {
        int n = s.length();

        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                dp[i][j] = -1;
            }
        }

        return (int)helper(s, 0, n - 1);
    }
}