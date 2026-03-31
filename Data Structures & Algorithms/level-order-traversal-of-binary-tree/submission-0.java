/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        List<TreeNode> temp = new ArrayList<>();
        ret.add(List.of(root.val));
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                temp.add(curr.left);
            }
            if (curr.right != null) {
                temp.add(curr.right);
            }
            if (q.isEmpty() && !temp.isEmpty()) {
                List<Integer> visitedValues = new ArrayList<Integer>();
                for(TreeNode x: temp) {
                    visitedValues.add(x.val);
                    q.offer(x);
                }
                ret.add(visitedValues);
                temp.clear();
            }
        }
        return ret;
    }
}
