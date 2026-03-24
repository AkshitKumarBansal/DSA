class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            sb.setLength(0);
            for(int i=0;i<word.length();i++) {
                char ch = word.charAt(i);
                sb.append(morseCode[ch-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}