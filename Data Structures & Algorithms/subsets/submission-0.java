class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    List<Integer> current = new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return answer;
    }

    public void backTrack(int[] nums, int start) {
        if (start == (nums.length)) {
            if (!answer.contains(current)) {
                answer.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(nums[start]);
        backTrack(nums, start + 1);
        current.remove(current.size() - 1);
        backTrack(nums, start + 1);
        return;
    } 
}
