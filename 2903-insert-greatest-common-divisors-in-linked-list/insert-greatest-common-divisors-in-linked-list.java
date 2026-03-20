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
        while(temp != null && temp.next != null) {
            int val = gcd(temp.val, temp.next.val);
            System.out.println(val);
            ListNode newTemp = new ListNode(val);
            newTemp.next = temp.next;
            temp.next = newTemp;
            temp = newTemp.next;
        }
        return head;
    }
    private int gcd(int a, int b) {
        if(b%a==0) return a;
        return gcd(b%a, a);
    }
}