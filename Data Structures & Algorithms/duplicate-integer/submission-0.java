class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> hashTable = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.contains(nums[i])) {
                return true;
            } else {
                hashTable.add(nums[i]);
            }
        }
        return false;
    }
}