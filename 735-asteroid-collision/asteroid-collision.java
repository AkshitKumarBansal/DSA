class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0;i<n;i++) {
            if(arr[i] < 0) {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i])) {
                    st.pop();
                }
                if(st.isEmpty() || (!st.isEmpty() && st.peek()<0)) st.push(arr[i]);
                if(!st.isEmpty() && st.peek()==Math.abs(arr[i])) st.pop();
            } else {
                st.push(arr[i]);
            }
        }
        int[] result = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()) {
            result[i--] = st.pop();
        }
        return result;
    }
}