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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        StringBuilder sb = new StringBuilder();
        path(root, list, sb);
        return list;
    }
    private void path(TreeNode root, List<String> list, StringBuilder sb) {
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        else {
            sb.append("->");
            if(root.left != null) path(root.left, list, sb);
            if(root.right != null) path(root.right, list, sb);
        }
        sb.setLength(len);
    }
}