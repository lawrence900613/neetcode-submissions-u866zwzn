class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(ret, sb, 0, 0, n);
        return ret;
    }

    public void backTrack(List<String> ret, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            ret.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backTrack(ret, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backTrack(ret, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}