class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String result = "";
        String[] words = s.split("\\s+");
        for(int i=words.length-1; i>=0; i--){
            result += words[i]+" ";
        }
        return result.trim();
    }
}