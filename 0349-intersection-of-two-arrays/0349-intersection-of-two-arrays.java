import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for (int n : nums1)
            set.add(n);

        for (int n : nums2) {
            if (set.contains(n))
                ans.add(n);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}