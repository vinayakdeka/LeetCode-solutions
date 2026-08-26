class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        int left = 0;
        int count = 0;

        String ans = "";

        for (int right = 0; right < n; right++) {

            // Count 1
            if (s.charAt(right) == '1') {
                count++;
            }

            // If we have more than k ones,
            // move left until we have exactly k ones
            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }

            // We have exactly k ones
            if (count == k) {

                // Remove unnecessary zeroes from left
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // Check shortest
                if (ans.equals("") ||
                    current.length() < ans.length()) {

                    ans = current;
                }

                // If same length, check lexicographically smaller
                else if (current.length() == ans.length() &&
                         current.compareTo(ans) < 0) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}