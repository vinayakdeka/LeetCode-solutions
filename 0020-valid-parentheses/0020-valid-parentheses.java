import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            // Closing brackets
            else {

                if (st.isEmpty())
                    return false;

                char top = st.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Valid only if no opening brackets are left
        return st.isEmpty();
    }
}