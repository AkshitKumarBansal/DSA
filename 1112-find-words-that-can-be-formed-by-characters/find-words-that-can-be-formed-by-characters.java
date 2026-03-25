class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for(int i=0;i<chars.length();i++) freq[chars.charAt(i)-'a']++;
        int[] freq1 = new int[26];
        int count = 0;
        for(String word : words) {
            for(int i=0;i<word.length();i++) freq1[word.charAt(i)-'a']++;
            boolean flag = true;
            for(int i=0;i<26;i++) if(freq[i]<freq1[i]) flag = false;
            if(flag) count+=word.length();
            Arrays.fill(freq1, 0);
        }
        return count;
    }
}