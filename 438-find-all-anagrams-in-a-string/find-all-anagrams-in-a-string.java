class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        int[] freqP = new int[26];
        int[] freqSub = new int[26];
        for(int k=0;k<p.length();k++){
            freqP[p.charAt(k)-'a']++;
            freqSub[s.charAt(k)-'a']++;
        }
        if (Arrays.equals(freqP, freqSub)) list.add(0);
        int i=0;
        int j=p.length();
        while(j<s.length()){
            freqSub[s.charAt(i)-'a']--;
            freqSub[s.charAt(j)-'a']++;
            if(Arrays.equals(freqP, freqSub)){
                list.add(i+1);
            }
            i++;
            j++;
        }
        return list;
    }
}