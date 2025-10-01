class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] freqP = new int[26];
        for(int i=0;i<p.length();i++){
            freqP[p.charAt(i)-'a']++;
        }
        int i=0;
        int j=p.length()-1;
        while(j<s.length()){
            if(yes(s.substring(i,j+1), freqP)){
                list.add(i);
            }
            i++;
            j++;
        }
        return list;
    }
    private boolean yes(String str,int freqP[]) {
        int[] freqSub = new int[26];
        for(int i=0;i<str.length();i++){
            freqSub[str.charAt(i)-'a']++;
        }
        if(Arrays.equals(freqSub, freqP)) return true;
        else return false;
    }
}