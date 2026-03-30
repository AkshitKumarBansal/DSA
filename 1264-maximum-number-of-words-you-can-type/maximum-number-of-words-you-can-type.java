class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] freq = new boolean[26];
        for(char c : brokenLetters.toCharArray()) freq[c-'a'] = true;
        String[] words = text.split("\\s+");
        int count = 0;
        for(String word : words) {
            for(char c : word.toCharArray()) {
                if(freq[c-'a']) {
                    count++;
                    break;
                }
            }
        }
        return words.length-count;
    }
}