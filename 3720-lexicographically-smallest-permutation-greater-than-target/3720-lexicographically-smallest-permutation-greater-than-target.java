class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        StringBuilder ans = new StringBuilder();

        return solve(0, target, cnt, ans) ? ans.toString() : "";
    }

    boolean solve(int i, String target, int[] cnt, StringBuilder ans) {

        if (i == target.length())
            return false; // equal to target, not greater

        int x = target.charAt(i) - 'a';

        // First try same character
        if (cnt[x] > 0) {
            cnt[x]--;
            ans.append((char)('a' + x));

            if (solve(i + 1, target, cnt, ans))
                return true;

            // backtrack
            ans.deleteCharAt(ans.length() - 1);
            cnt[x]++;
        }

        // Try smallest character greater than target[i]
        for (int c = x + 1; c < 26; c++) {

            if (cnt[c] > 0) {

                cnt[c]--;
                ans.append((char)('a' + c));

                // Remaining characters in sorted order
                for (int j = 0; j < 26; j++)
                    while (cnt[j]-- > 0)
                        ans.append((char)('a' + j));

                return true;
            }
        }

        return false;
    }
}