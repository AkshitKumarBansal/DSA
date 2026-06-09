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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++) {
            solve(preorder[i], root);
        }
        return root;
    }
    private void solve(int ele, TreeNode root) {
        if(root.val > ele) {
            if(root.left != null) solve(ele, root.left);
            else {
                root.left = new TreeNode(ele);
                return;
            }
        }
        if(root.val < ele) {
            if(root.right != null) solve(ele, root.right);
            else {
                root.right = new TreeNode(ele);
                return;
            }
        }
    }
}