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
    private int counter = 0;
    private int smallestVal = 0;
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        dfs(root, k);
        return smallestVal;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        counter += 1;
        if (counter == k) {
            smallestVal = root.val;
        }
        dfs(root.right, k);
    }
}
