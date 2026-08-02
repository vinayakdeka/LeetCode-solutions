class Solution {
    private final String[] MAPPING = {
        "",    "",    "abc", "def", 
        "ghi", "jkl", "mno", "pqrs", 
        "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: if current path length matches digits length, add to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to the current digit
        char digit = digits.charAt(index);
        String letters = MAPPING[digit - '0'];

        // Iterate through letters and recurse
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}