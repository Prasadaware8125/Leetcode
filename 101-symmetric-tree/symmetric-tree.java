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
    public boolean checkSymmetric(TreeNode l, TreeNode r) {
        if( l == null && r == null ) return true;
        if( l != null && r == null ) return false;
        if( l == null && r != null ) return false;

        if( l.val != r.val ) return false;
        boolean left = checkSymmetric(l.left, r.right); 
        boolean right = checkSymmetric(l.right, r.left); 

        return left && right;
    }
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left, root.right);
    }
}