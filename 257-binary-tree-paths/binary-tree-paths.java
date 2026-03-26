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
    List<String> res = new ArrayList<>();

    public void findPath(TreeNode root, StringBuilder path) {
        if (root == null) return;
        int len = path.length();
        path.append(Integer.toString(root.val));
        
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        } else {
            path.append("->");
            findPath(root.left, path);
            findPath(root.right, path);
        }

        path.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        findPath(root, new StringBuilder(""));
        return res;
    }
}