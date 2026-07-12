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
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> rootMap = new HashMap<>();        
        Set<Integer> leafSet = new HashSet<>();        
        for (TreeNode root : trees) {
            rootMap.put(root.val, root);            
            if (root.left != null) {
                leafSet.add(root.left.val);
            }
            if (root.right != null) {
                leafSet.add(root.right.val);
            }
        }
        TreeNode node = null;
        for (TreeNode root : trees) {
            if (!leafSet.contains(root.val)) {
                node = root;
                break;
            }
        }
        if(node == null) return null;
        rootMap.remove(node.val);
        if (isValidBSTAndMerge(node, Integer.MIN_VALUE, Integer.MAX_VALUE, rootMap)) {
            if (rootMap.isEmpty()) {
                return node;
            }
        }
        return null;
    }
    private boolean isValidBSTAndMerge(TreeNode node, int min, int max, Map<Integer, TreeNode> rootMap) {
        if (node == null) {
            return true;
        }        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (rootMap.containsKey(node.val)) {
                TreeNode treeToMerge = rootMap.get(node.val);
                rootMap.remove(node.val);
                node.left = treeToMerge.left;
                node.right = treeToMerge.right;
            }
        }
        return isValidBSTAndMerge(node.left, min, node.val, rootMap) && 
               isValidBSTAndMerge(node.right, node.val, max, rootMap);
    }
}