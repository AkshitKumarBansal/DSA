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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val >= low && root.val<= high) sum += root.val;
        if(root.left != null) rangeSumBST(root.left, low, high);
        if(root.right != null) rangeSumBST(root.right, low, high);
        // List<Integer> list = new ArrayList<>();
        // inorder(root, list);
        // int sum = 0;
        // for(int i=0;i<list.size();i++) {
        //     if(list.get(i)>=low && list.get(i)<=high) {
        //         sum += list.get(i);
        //     }
        // }
        return sum;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}