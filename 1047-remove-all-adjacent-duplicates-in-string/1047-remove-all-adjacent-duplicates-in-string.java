class Solution {
    public String removeDuplicates(String s) {

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            // If top of stack == current character
            if (stack.length() > 0 &&
                stack.charAt(stack.length() - 1) == ch) {

                // Remove the duplicate
                stack.deleteCharAt(stack.length() - 1);

            } else {

                // Push current character
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}