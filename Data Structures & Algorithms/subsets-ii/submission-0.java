class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backTrack(nums, 0, curr, ret);
        return ret;
    }

    public void backTrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> ret) {
        List<Integer> copy = new ArrayList<>(curr);
        Collections.sort(copy);
        if (!ret.contains(copy)) {
            ret.add(copy);
        } 
        if (start == nums.length) {
            return;
        }
        curr.add(nums[start]);
        backTrack(nums, start + 1, curr, ret);
        curr.remove(curr.size() - 1);
        backTrack(nums, start + 1, curr, ret);
    }
}
