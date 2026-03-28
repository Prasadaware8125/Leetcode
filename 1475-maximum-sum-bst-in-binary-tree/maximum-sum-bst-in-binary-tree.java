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
    // Created class to track the info 
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;

        public Info(boolean isBST, int size, int min, int max, int sum) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    // to maintain the max sum while travesring the tree
    int maxSum = 0;

    public Info largestBST( TreeNode root ) {
        // Base Case
        // if root is null then it is BST
        if( root == null ) {
            return new Info( true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Traverse left and right subtree
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // Calculate size of current tree, its minimum and maximum values, and current sum
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.val, Math.min( leftInfo.min, rightInfo.min ));
        int max = Math.max(root.val, Math.max( leftInfo.max, rightInfo.max ));
        int sum = root.val + leftInfo.sum + rightInfo.sum;

        // Valid BST
        if( leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.val && root.val < rightInfo.min) {
            // Update masSum
            maxSum = Math.max(maxSum, sum);
            return new Info(true, size, min, max, sum);
        }

        return new Info(false, size, min, max, sum);
    }

    public int maxSumBST(TreeNode root) {
        Info maxBST = largestBST(root);
        return maxSum;
    }
}