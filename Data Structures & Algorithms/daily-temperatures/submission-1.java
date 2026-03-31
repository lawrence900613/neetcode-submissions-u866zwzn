class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer> ();
        int[] ret = new int[temperatures.length];
        int pointer = temperatures.length - 1;
        while (pointer >= 0) {
            while (!stack.isEmpty() && temperatures[pointer] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ret[pointer] = 0;
            } else {
                ret[pointer] = stack.peek() - pointer;
            }
            stack.push(pointer);
            pointer--;
        }
        return ret;
    }
}


// 28

// 40

// 40 35

// 35 40

// 36 40