/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(ans[i], -1);
        }
        ListNode temp = head;
        int top = 0, bottom = m-1, left = 0, right = n-1;
        int len = 0;
        while(temp != null && left<=right && top<=bottom) {
            for(int i=left;i<=right && temp != null;i++) {
                ans[top][i] = (int)temp.val;
                temp = temp.next;
            }
            top++;
            for(int i=top;i<=bottom && temp != null;i++) {
                ans[i][right] = (int)temp.val;
                temp = temp.next;
            }
            right--;
            for(int i=right;i>=left && temp != null;i--) {
                ans[bottom][i] = (int)temp.val;
                temp = temp.next;
            }
            bottom--;
            for(int i=bottom;i>=top && temp != null;i--) {
                ans[i][left] = (int)temp.val;
                temp = temp.next;
            }
            left++;
        }
        return ans;
    }
}