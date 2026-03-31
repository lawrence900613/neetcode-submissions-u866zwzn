class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        backTrack(candidates, 0, ret, curr, target);
        return ret;
    }

    public void backTrack(int[] nums, int start, List<List<Integer>> ret, List<Integer> curr, int target) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(curr);
            Collections.sort(temp);
            if (!ret.contains(temp)) {
                ret.add(temp);
            }
            return;
        } else if (start != (nums.length)) {
            curr.add(nums[start]);
            backTrack(nums, start + 1, ret, curr, target - nums[start]);
            curr.remove(curr.size() - 1);
            backTrack(nums, start + 1, ret, curr, target);
        }
    }
 }
