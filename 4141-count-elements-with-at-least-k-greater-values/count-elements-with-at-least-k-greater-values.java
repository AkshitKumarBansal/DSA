class Solution {
    public int countElements(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int greaterCount = 0;
        int ans = 0;

        for (int val : map.descendingKeySet()) {
            int freq = map.get(val);

            if (greaterCount >= k) {
                ans += freq;
            }

            greaterCount += freq;
        }

        return ans;
    }
}