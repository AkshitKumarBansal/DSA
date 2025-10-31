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
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        inorder(root, list, new StringBuilder());
        int sum = 0;
        for(int i=0;i<list.size();i++) {
            sum += Integer.parseInt(list.get(i), 2);
        }
        return sum;
    }
    private void inorder(TreeNode root, List<String> list, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val);
        if(root.left==null && root.right==null){
            list.add(sb.toString());
            return;
        }
        inorder(root.left, list, new StringBuilder(sb));
        inorder(root.right, list, new StringBuilder(sb));
    }
}