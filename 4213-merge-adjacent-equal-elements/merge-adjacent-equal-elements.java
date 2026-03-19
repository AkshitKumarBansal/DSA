class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        List<Long> result = new ArrayList<>();
        for(int num : nums) {
            long newNum = num;
            while(!st.isEmpty() && st.peek()==newNum) {
                newNum += st.pop();
            }
            st.push(newNum);
        }
        while(!st.isEmpty()) {
            result.add(st.pop());
        }
        Collections.reverse(result);
        return result;
    }
}