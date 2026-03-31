class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n]; 
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            rightSmallest[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightSmallest[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < n; i++) {
            leftSmallest[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftSmallest[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftSmallest[i] += 1;
            rightSmallest[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightSmallest[i] - leftSmallest[i] + 1));
        }
        return maxArea;
    }
}

// 4, 7, 1