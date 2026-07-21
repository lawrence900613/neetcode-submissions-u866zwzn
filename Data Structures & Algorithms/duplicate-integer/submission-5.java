class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> hashMap = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.contains(nums[i])) {
                return true;
            } else {
                hashMap.add(nums[i]);
            }
        }
        return false;
    }
}