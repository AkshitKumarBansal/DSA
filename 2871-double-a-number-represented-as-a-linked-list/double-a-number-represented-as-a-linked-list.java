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
    public ListNode doubleIt(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTemp = newHead;
        int carry = 0;
        while(prev != null) {
            int num = (2*prev.val + carry)%10;
            newTemp.next = new ListNode(num);
            carry = (2*prev.val)/10;
            newTemp = newTemp.next;
            prev = prev.next;
        }
        if(carry != 0) {
            newTemp.next = new ListNode(carry);
            newTemp = newTemp.next;
        }
        curr = newHead.next;
        prev = null;
        temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}