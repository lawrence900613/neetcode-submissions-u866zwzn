class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int l_max = 0;
        int r_max = 0;
        int ret = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (r_max > l_max) {
                ret += l_max - height[left];
                left ++;
            } else {
                ret += r_max - height[right];
                right--;
            }
        }
        return ret;
    }
}
