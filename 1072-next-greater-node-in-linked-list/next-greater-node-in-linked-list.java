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
    public int[] nextLargerNodes(ListNode head) {

        List<Integer> arr = new ArrayList<>();

        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int n = arr.size();
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() <= arr.get(i)) {
                st.pop();
            }

            result[i] = st.isEmpty() ? 0 : st.peek();

            st.push(arr.get(i));
        }

        return result;
    }
}