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
    public int maxDepth(TreeNode root) {
        // if(root == null) return 0;
        // List<List<Integer>> res = new ArrayList<>(); // using levelOrder
        // Queue<TreeNode> queue = new ArrayDeque<>();
        // queue.offer(root);
        // while(!queue.isEmpty()) {
        //     int level = queue.size();
        //     List<Integer> list = new ArrayList<>();
        //     for(int i=0;i<level;i++) {
        //         if(queue.peek().left != null) queue.offer(queue.peek().left);
        //         if(queue.peek().right != null) queue.offer(queue.peek().right);
        //         list.add(queue.poll().val);
        //     }
        //     res.add(new ArrayList<>(list));
        // }
        // return res.size();

        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1+Math.max(lh, rh);
    }
}