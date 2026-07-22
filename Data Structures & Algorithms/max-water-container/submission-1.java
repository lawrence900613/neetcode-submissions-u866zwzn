class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.min(heights[l], heights[r]) * (r - l));
            if(heights[l] < heights[r]) {
                l+=1;
            } else {
                r-=1;
            }
        }
        return max;
    }
}
