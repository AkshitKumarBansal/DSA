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
class BSTIterator {
    private List<Integer> inorderList;
    private int index;

    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<>();
        index = 0;
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorderList.add(root.val);
        inorderTraversal(root.right);
    }

    public int next() {
        return inorderList.get(index++);
    }

    public boolean hasNext() {
        return index < inorderList.size();
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */