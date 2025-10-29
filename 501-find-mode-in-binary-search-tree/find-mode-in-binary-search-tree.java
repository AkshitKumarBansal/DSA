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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(max == entry.getValue()) {
                arr[i++] = entry.getKey();
            }
        }
        return Arrays.copyOf(arr, i);
    }
    private void inorder(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) return;
        inorder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorder(root.right, map);
    } 
}