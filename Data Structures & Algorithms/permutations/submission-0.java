class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        List<Integer> curr = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backTrack(nums, map, curr, ret);
        return ret;
    }

    public void backTrack(int[] nums, HashMap<Integer, Boolean> map, List<Integer> curr, List<List<Integer>> ret) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                curr.add(nums[i]);
                map.put(nums[i], true);
                backTrack(nums, map, curr, ret);
                curr.remove(curr.size() - 1);
                map.remove(nums[i]);
            }   
        }
    } 
}
