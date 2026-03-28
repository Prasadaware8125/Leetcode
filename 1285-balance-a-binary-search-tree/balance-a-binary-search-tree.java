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
    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if( root == null ) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public TreeNode createBST(ArrayList<Integer> arr, int st, int end) {
        if( st > end ) return null;

        if( st == end ) {     // Leaf Node
            TreeNode leaf = new TreeNode(arr.get(st));
            leaf.left = null;
            leaf.right = null;
            return leaf;
        }   

        int mid = ( st + end ) / 2;

        TreeNode root = new TreeNode(arr.get(mid));

        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return createBST(arr, 0, arr.size()-1);
    }
}