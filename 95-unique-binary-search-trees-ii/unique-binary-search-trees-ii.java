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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        Map<String, TreeNode> uniqueTrees = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) list.add(i);
        List<List<Integer>> permutations = new ArrayList<>();
        permutation(list, permutations, new ArrayList<>());
        for (List<Integer> p : permutations) {
            TreeNode root = null;
            for (int val : p) {
                root = Tree(root, val);
            }            
            String serialized = serialize(root);
            if (!uniqueTrees.containsKey(serialized)) {
                uniqueTrees.put(serialized, root);
            }
        }
        return new ArrayList<>(uniqueTrees.values());
    }
    private void permutation(List<Integer> list, List<List<Integer>> result, List<Integer> copy) {
        if(copy.size()==list.size()) {
            result.add(new ArrayList<>(copy));
            return;
        }
        for(int i=0;i<list.size();i++) {
            if (copy.contains(list.get(i))) {
                continue;
            }   
            copy.add(list.get(i));
            permutation(list, result, copy);
            copy.remove(copy.size()-1);
        }
    } 
    private TreeNode Tree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = Tree(root.left, val);
        } else if (val > root.val) {
            root.right = Tree(root.right, val);
        }
        return root;
    }
    private String serialize(TreeNode root) {
        if (root == null) return "N";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }
}