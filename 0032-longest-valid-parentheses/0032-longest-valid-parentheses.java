class Solution {
    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int max = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            // Valid substring
            if (left == right) {
                max = Math.max(max, 2 * right);
            }

            // Too many closing brackets
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        // Right to Left
        left = 0;
        right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            // Valid substring
            if (left == right) {
                max = Math.max(max, 2 * left);
            }

            // Too many opening brackets
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }
}