
class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // If the next character is ')',
                // we have a pair '))'.
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert one ')' to complete '))'.
                    ans++;
                }

                // No '(' available to match this '))'.
                if (open == 0) {
                    ans++;
                } else {
                    open--;
                }
            }
        }

        // Every unmatched '(' needs two ')'.
        ans += open * 2;

        return ans;
    }
}
