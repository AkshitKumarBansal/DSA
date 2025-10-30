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
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = list.get(list.size()-1) - list.get(list.size()-2);
        for(int i=list.size()-2;i>0;i--) {
            min = Math.min(min, list.get(i)-list.get(i-1));
        } 
        return min;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}