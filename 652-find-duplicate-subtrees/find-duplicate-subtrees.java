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
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        inorder(root);
        return res;
    }
    private String inorder(TreeNode root) {
        if(root == null) {
            return "#";
        }
        String left = inorder(root.left);
        String right = inorder(root.right);
        String str = root.val + ',' + left + ',' + right;
        map.put(str, map.getOrDefault(str, 0) + 1);
        if(map.get(str)==2) {
            res.add(root);
        }
        return str;
    }
}