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
    int diameterSum = Integer.MIN_VALUE;
    public int dfs(TreeNode root) {
        if( root == null ) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        if( leftSum < 0 ) leftSum = 0;
        if( rightSum < 0 ) rightSum = 0;
        
        diameterSum = Math.max(diameterSum, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return diameterSum;
    }
}