class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        for(String str : strs) {
            int i=0;
            int min = Math.min(sb.length(), str.length());
            while(i<min && sb.charAt(i)==str.charAt(i)){
                i++;
            }
            sb.setLength(i);
        }
        return sb.toString();
    }
}