class Solution {
public:
    bool checkValidString(string s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--;  // '*' acts as ')'
                maxOpen++;  // '*' acts as '('
            }

            // Even the maximum possible opens became negative
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative
            minOpen = max(0, minOpen);
        }

        return minOpen == 0;
    }
};