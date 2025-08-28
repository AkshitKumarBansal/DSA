class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split("\\s+");
        int i=1;
        for(String word : arr){
            if(isVowel(word.charAt(0))){
                sb.append(word).append("ma").append("a".repeat(i)).append(" ");
            }
            else{
                sb.append(word.substring(1)).append(word.charAt(0)).append("ma").append("a".repeat(i)).append(" ");
            }
            i++;
        }
        return sb.toString().trim();
    }
    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}