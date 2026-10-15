class Solution {
    public String removeSubstring(String s, int k) {
        List<int[]> stack = new ArrayList<>();

        for (char c : s.toCharArray()) {

            // Store consecutive identical characters
            if (!stack.isEmpty() &&
                stack.get(stack.size() - 1)[0] == c) {

                stack.get(stack.size() - 1)[1]++;

            } else {
                stack.add(new int[]{c, 1});
            }

            // Check if a k-balanced substring is formed
            if (c == ')' && stack.size() >= 2) {

                int[] close = stack.get(stack.size() - 1);
                int[] open = stack.get(stack.size() - 2);

                if (close[1] == k && open[1] >= k) {

                    // Remove k closing brackets
                    stack.remove(stack.size() - 1);

                    // Remove k opening brackets
                    open[1] -= k;

                    if (open[1] == 0) {
                        stack.remove(stack.size() - 1);
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int[] group : stack) {
            for (int i = 0; i < group[1]; i++) {
                ans.append((char) group[0]);
            }
        }

        return ans.toString();
    }
};
