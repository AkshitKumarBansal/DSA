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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int root = preorder[0];
        int ind = 0;
        for(int i=0;i<inorder.length;i++) {
            if(root==inorder[i]) ind = i;
        }
        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1,ind+1), Arrays.copyOfRange(inorder, 0, ind));
        node.right = buildTree(Arrays.copyOfRange(preorder,ind+1, preorder.length), Arrays.copyOfRange(inorder, ind+1, inorder.length));
        return node;
    }
}