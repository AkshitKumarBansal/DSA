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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        ListNode newHead = new ListNode(0);
        ListNode newTemp = newHead;
        while(temp != null) {
            newTemp.next = new ListNode(temp.val);
            newTemp = newTemp.next;
            if(temp.next != null) {
                int val = gcd(temp.val, temp.next.val);
                System.out.println(val);
                newTemp.next = new ListNode(val);
                newTemp = newTemp.next;
            }
            temp = temp.next;
        }
        return newHead.next;
    }
    private int gcd(int a, int b) {
        if(b%a==0) return a;
        return gcd(b%a, a);
    }
}