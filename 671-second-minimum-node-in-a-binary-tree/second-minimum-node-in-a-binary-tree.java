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
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++) {
            min = Math.min(list.get(i), min);
        }
        int smin = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i=0;i<list.size();i++) {
            if(list.get(i)>min && smin>=list.get(i)) {
                smin = list.get(i);
                flag = true;
            }
        }
        return flag==false ? -1 : smin;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    } 
}