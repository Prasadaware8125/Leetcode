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
    public TreeNode createBST(int[] nums, int st, int end) {
        // Base Case
        if( st > end ) {
            return null;
        }

        // Find mid of the array
        int mid = ( st + end ) /2;

        // Make mid element the root
        TreeNode root = new TreeNode(nums[mid]);

        // making left subtree of root by recursive call to the left part of nums
        root.left = createBST(nums, st, mid-1);
        // making right subtree of root by recursive call to the right part of nums
        root.right = createBST(nums, mid+1, end);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = createBST(nums, 0, nums.length-1);
        return root;
    }
}