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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if(root == null) return res;
        int h = height(root);
        int row = h+1;
        int col = (int)Math.pow(2, (h+1)) - 1;
        for(int i=0;i<row;i++) {
            List<String> rowFill = new ArrayList<>(Collections.nCopies(col, ""));
            res.add(rowFill);
        }
        fill(root, 0, (col - 1) / 2, h, res);
        return res;
    }
    private void fill(TreeNode root, int r, int c, int height, List<List<String>> res) {
        if (root == null) return;
        res.get(r).set(c, String.valueOf(root.val));
        int offset = (int) Math.pow(2, height - r - 1);
        fill(root.left, r + 1, c - offset, height, res);
        fill(root.right, r + 1, c + offset, height, res);
    }
    private int height(TreeNode root) {
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}