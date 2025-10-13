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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        Sum(root);
        return max;
    }
    private int Sum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = Math.max(0, Sum(root.left));
        int rightSum = Math.max(0, Sum(root.right));
        max = Math.max(max, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}