class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put(']', '[');
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for(Character c: s.toCharArray()) {
            if(bracketMap.get(c) == null) {
                stack.push(c);
            } else if(stack.size() == 0 || stack.pop() != bracketMap.get(c)) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
