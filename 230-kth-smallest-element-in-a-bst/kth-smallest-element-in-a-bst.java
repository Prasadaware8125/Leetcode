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
    int count, val;
    public void find( TreeNode root, int k ) {
        if( root == null ) {
            return ;
        }
        find(root.left, k);
        count++;
        if( count == k ) {
            val = root.val;
            return;
        } 
        find(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        val = -1;
        find(root, k);
        return val;
    }
}