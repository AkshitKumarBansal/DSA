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
    private int sum = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return sum;
    }
    private int sum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        sum += Math.abs(leftSum-rightSum);
        return root.val+leftSum+rightSum;
    }
}