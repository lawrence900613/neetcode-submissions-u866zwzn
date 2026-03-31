class Solution {
    public boolean isValid(String s) {
        List<Character> list = new ArrayList<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                list.add(bracket);
            } else if (list.size() == 0) {
                return false;
            } else if (map.get(bracket) != list.get(list.size() - 1)) {
                return false;
            } else {
                list.remove(list.size() - 1);
            }
        }
        if (list.size() != 0){
            return false;
        }        
        return true;
    }
}
