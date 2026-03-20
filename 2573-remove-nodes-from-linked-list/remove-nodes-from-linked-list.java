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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int max = head.val;
        while(temp != null && temp.next != null) {
            if(temp.next.val<max) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
                max = temp.val;
            }
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        ListNode temp = null;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}