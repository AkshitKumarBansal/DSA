class Solution {
    public int minDeletion(String s, int k) {
        int[] freq = new int[26];
        for (char x : s.toCharArray()) {
            freq[x-'a']++;
        }
        int count = 0;
        for(int x : freq) {
            if(x!=0) count++;
        }
        if(k >= count) return 0;
        Arrays.sort(freq);
        int i = 25;
        while(k > 0 && i >= 0) {
            freq[i] = 0;
            k--;
            i--;
        }
        count = 0;
        for(int x : freq) count += x;
        return count; 
    }
}