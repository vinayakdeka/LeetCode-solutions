class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        // Store nums1
        for (int num : nums1) {
            set.add(num);
        }

        // Find common elements
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        // Convert Set to int[]
        int[] result = new int[ans.size()];
        int i = 0;

        for (int num : ans) {
            result[i++] = num;
        }

        return result;
    }
}