class Solution {
    public int minLengthAfterRemovals(String s) {
        // Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='a') count++;
            else count--;
        }
        return (count<0) ? count*-1 : count;
    }
}