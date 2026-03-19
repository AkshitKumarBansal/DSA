class Solution {
    public int maxBalancedShipments(int[] weight) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        for(int i=0;i<weight.length;i++) {
            if(!st.isEmpty() && st.peek()>weight[i]) {
                count++;
                while(!st.isEmpty()) st.pop();
            } else {
                st.push(weight[i]);
            }
        }
        return count;
    }
}