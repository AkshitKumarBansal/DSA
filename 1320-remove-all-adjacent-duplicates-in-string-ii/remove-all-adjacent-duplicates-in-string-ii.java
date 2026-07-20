class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> st=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==ch){
                st.peek()[1]++;
                if(st.peek()[1]==k) st.pop();
            }
            else st.push(new int[]{ch,1});
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            int[] pair=st.pop();
            char ch=(char)pair[0];
            int rep=pair[1];
            for(int i=0;i<rep;i++) sb.append(ch);
        }
        return sb.reverse().toString();
    }
}