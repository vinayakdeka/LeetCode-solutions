class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0, high = n1;

        while (low <= high) {

            int cnt1 = (low + high) / 2;
            int cnt2 = (n1 + n2 + 1) / 2 - cnt1;

            int l1 = (cnt1 == 0) ? Integer.MIN_VALUE : nums1[cnt1 - 1];
            int l2 = (cnt2 == 0) ? Integer.MIN_VALUE : nums2[cnt2 - 1];

            int r1 = (cnt1 == n1) ? Integer.MAX_VALUE : nums1[cnt1];
            int r2 = (cnt2 == n2) ? Integer.MAX_VALUE : nums2[cnt2];

            if (l1 <= r2 && l2 <= r1) {

                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }

            } else if (l1 > r2) {
                high = cnt1 - 1;
            } else {
                low = cnt1 + 1;
            }
        }

        return 0.0;
    }
}