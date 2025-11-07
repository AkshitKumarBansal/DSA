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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return new TreeNode(val);
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0;i<len;i++) {
                TreeNode node = q.poll();
                if(level == (depth-1)) {
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val);
                    node.left.left = left;
                    node.right = new TreeNode(val);
                    node.right.right = right;
                } else {
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
            }
            level++;
        }
        return root;
    }
}