class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> currPath = new ArrayList<Integer>();
        dfs(nums, 0, target, currPath, ret);
        return ret;
    }

    public void dfs(int[] nums, int start, int target, List<Integer> currPath, List<List<Integer>> ret) {
        if (start >= nums.length) {
            return;
        }
        if ((target - nums[start]) == 0) {
            currPath.add(nums[start]);
            ret.add(List.copyOf(currPath));
            currPath.remove(currPath.size() - 1);
        }
        if (target < 0) {
            return;
        }
        currPath.add(nums[start]);
        dfs(nums, start, target - nums[start], currPath, ret);
        currPath.remove(currPath.size() - 1);
        dfs(nums, start + 1, target, currPath, ret);
    }

    // 8 -> 8 (x) -> 4 (x) -> 3
}
