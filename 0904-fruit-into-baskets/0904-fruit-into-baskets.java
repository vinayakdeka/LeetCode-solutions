class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // More than 2 types
            while (map.size() > 2) {

                int fruit = fruits[left];

                map.put(fruit, map.get(fruit) - 1);

                // Remove fruit completely
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                left++;
            }

            // Current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}