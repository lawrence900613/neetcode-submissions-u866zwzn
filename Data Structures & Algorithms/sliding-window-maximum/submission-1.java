class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);
        int[] output = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            p.offer(nums[right]);
            if (p.size() == k) {
                output[left] = p.peek();
                p.remove(nums[left]);
                left += 1;
            }
        }
        return output;
    }
}
