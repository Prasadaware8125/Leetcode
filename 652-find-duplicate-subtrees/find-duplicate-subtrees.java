class Solution {
    public String find(TreeNode root, ArrayList<TreeNode> res, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }

        String left = find(root.left, res, map);
        String right = find(root.right, res, map);

        String curr = left + "," + right + "," + root.val;

        if( map.containsKey(curr) ) {
            if( map.get(curr) == 1 ) {
                res.add(root);
            }
            map.put(curr, map.get(curr)+1);
        } else {
            map.put(curr, 1);
        }

        return curr;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        find(root, res, map);
        return res;
    }
}