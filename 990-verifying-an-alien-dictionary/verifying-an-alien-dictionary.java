class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] freq = new int[26];
        for(int i=0;i<26;i++) {
            char ch = order.charAt(i);
            freq[ch-'a'] = i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<words.length;i++) {
            boolean flag = false;
            for(int j=0;j<words[i].length() && j<words[i-1].length();j++) {
                int ind1 = freq[words[i-1].charAt(j)-'a'];
                int ind2 = freq[words[i].charAt(j)-'a'];
                if(ind1 > ind2) return false;
                if(ind1 < ind2) {
                    flag = true;
                    break;
                }
            }
            if(!flag && words[i].length()<words[i-1].length()) return false;
        }
        return true;
    }
}