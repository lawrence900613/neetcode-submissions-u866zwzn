class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> ret = new ArrayList<Integer>();
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            p.offer(nums[right]);
            if (p.size() == k) {
                ret.add(p.peek());
                p.remove(nums[left]);
                left += 1;
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}
