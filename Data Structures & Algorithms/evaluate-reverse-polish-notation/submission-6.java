class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s: tokens) {
            if (isNumber(s)) {
                stack.add(Integer.parseInt(s));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.add(val2 + val1);
                        break;
                    case "-":
                        stack.add(val2 - val1);
                        break;
                    case "*":
                        stack.add(val2 * val1);
                        break;
                    default:
                        stack.add(val2/val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String s) {
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }
}
