class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}