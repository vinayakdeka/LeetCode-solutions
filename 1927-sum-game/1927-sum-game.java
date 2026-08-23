class Solution {
    public boolean sumGame(String num) {

        int n = num.length();
        int mid = n / 2;

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // Process left half
        for (int i = 0; i < mid; i++) {

            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        // Process right half
        for (int i = mid; i < n; i++) {

            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int sumDiff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        /*
         * If the number of '?' is odd, Alice always wins.
         */
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        /*
         * Bob wins only if the current sum difference
         * can be exactly compensated by the '?' characters.
         */
        return sumDiff != -9 * qDiff / 2;
    }
}