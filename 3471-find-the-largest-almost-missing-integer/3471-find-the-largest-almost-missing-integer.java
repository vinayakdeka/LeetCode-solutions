class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == n
        if (k == n) {

            int max = 0;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Count frequency of every number
        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }

        // Case 2: k == 1
        if (k == 1) {

            int max = -1;

            for (int num : nums) {

                if (freq[num] == 1) {
                    max = Math.max(max, num);
                }
            }

            return max;
        }

        // Case 3: 1 < k < n
        int answer = -1;

        // First element
        if (freq[nums[0]] == 1) {
            answer = Math.max(answer, nums[0]);
        }

        // Last element
        if (freq[nums[n - 1]] == 1) {
            answer = Math.max(answer, nums[n - 1]);
        }

        return answer;
    }
}