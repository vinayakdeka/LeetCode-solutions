
import java.util.*;

class Solution {
    public int largestInteger(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Separate even and odd digits
        for (char c : digits) {
            int d = c - '0';

            if (d % 2 == 0) {
                even.add(d);
            } else {
                odd.add(d);
            }
        }

        // Sort both groups in descending order
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());

        int e = 0, o = 0;
        int result = 0;

        // Rebuild the number, preserving each position's parity
        for (char c : digits) {
            int d = c - '0';

            if (d % 2 == 0) {
                result = result * 10 + even.get(e++);
            } else {
                result = result * 10 + odd.get(o++);
            }
        }

        return result;
    }
}
