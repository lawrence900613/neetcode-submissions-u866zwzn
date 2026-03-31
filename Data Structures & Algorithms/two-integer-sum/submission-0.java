class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashTable.containsKey(diff) && hashTable.get(diff) != i) {
                return new int[]{i, hashTable.get(diff)};
            }
        }
        return new int[]{};
    }
}
