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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode node = new TreeNode(list.get(list.size()/2));
        node.left = build(list.subList(0, list.size() / 2));
        node.right = build(list.subList(list.size() / 2 + 1, list.size()));
        return node;
    }
    private TreeNode build(List<Integer> list) {
        if (list.size() == 0)
            return null;
        int mid = list.size() / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list.subList(0, mid));
        node.right = build(list.subList(mid + 1, list.size()));
        return node;
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}