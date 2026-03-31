class Solution {
    public int maxProduct(int[] nums) {
        int ret = nums[0];
        int min = 1, max = 1;
        for (int num: nums) {
            int tmp = max * num;
            max = Math.max(Math.max(num * max, num * min), num);
            min = Math.min(Math.min(tmp, num * min), num);
            ret = Math.max(ret, max);
        }
        return ret;
    }
}

 