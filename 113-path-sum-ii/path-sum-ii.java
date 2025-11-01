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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        // if((root.left != null || root.right != null) && root.val == targetSum) return res;
        Sum(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    private void Sum(TreeNode root, int target, List<Integer> list, List<List<Integer>> res) {
        if(root == null) return;
        list.add(root.val);
        if(target-root.val == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        Sum(root.left, target-root.val, list, res);
        Sum(root.right, target-root.val, list, res);
        list.remove(list.size()-1);
    }
}