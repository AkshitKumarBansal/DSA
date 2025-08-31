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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;
            int sum = l1_val + l2_val + carry;
            carry = sum / 10;
            int lastDigit = sum % 10;
            temp.next = new ListNode(lastDigit);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            temp = temp.next;
        }
        if(carry > 0){
            temp.next = new ListNode(carry);
        }
        return newHead.next;
    }
}