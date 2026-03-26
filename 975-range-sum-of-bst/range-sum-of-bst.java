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
    int sum = 0;
    
    public void findSum(TreeNode root, int low, int high) {
        if( root == null ) return;

        if( low <= root.val && root.val <= high ) {
            findSum(root.left, low, high);
            sum += root.val;
            findSum(root.right, low, high);
        } else if( high < root.val ) {
            findSum(root.left, low, high);
        } else {
            findSum(root.right, low, high);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        findSum(root, low, high);
        return sum;
    }
}