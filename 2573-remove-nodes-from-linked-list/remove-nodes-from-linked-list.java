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
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            while(!st.isEmpty() && st.peek()<temp.val) st.pop();
            st.push(temp.val);
            temp = temp.next;
        }
        ListNode newHead = new ListNode(st.pop());
        ListNode newTemp = newHead;
        while(!st.isEmpty()) {
            newTemp.next = new ListNode(st.pop());
            newTemp = newTemp.next;
        }
        newTemp = null;
        ListNode curr = newHead;
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