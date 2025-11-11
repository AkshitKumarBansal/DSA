class Solution {
    public int minTimeToType(String word) {
        char x = 'a';
        int count = 0;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            count += Math.min(Math.abs(ch-x), 26-Math.abs(ch-x))+1;
            x = ch;
        }
        return count;
    }
}