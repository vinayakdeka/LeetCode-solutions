import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // If valid, add to result
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                // Don't generate next level
                // once valid strings are found
                if (found) {
                    continue;
                }

                // Try removing each character
                for (int j = 0; j < current.length(); j++) {

                    // Only remove parentheses
                    if (current.charAt(j) != '(' &&
                        current.charAt(j) != ')') {
                        continue;
                    }

                    String next =
                        current.substring(0, j) +
                        current.substring(j + 1);

                    // Avoid duplicates
                    if (!visited.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // We found minimum-removal solutions
            if (found) {
                break;
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {

                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}