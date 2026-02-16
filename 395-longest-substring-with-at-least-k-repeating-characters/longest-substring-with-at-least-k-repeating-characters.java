class Solution {
    public int longestSubstring(String s, int k) {
        // if(s.length()<k) return 0;
        // int i = 0;
        // int j = k;
        // int max = 0;
        // int count = 0;
        // int[] freq = new int[26];
        // for(int x=i;x<j;x++) {
        //     freq[s.charAt(x)-'a']++;
        // }
        // for(int x=0;x<26;x++) {
        //     if(freq[x]<k && freq[x]!=0) count++;
        // }
        // System.out.println(count+"f");
        // while(j<s.length()) {
        //     if(count == 0) max = Math.max(max, j-i);
        //     System.out.println(max);
        //     freq[s.charAt(j)-'a']++;
        //     if(freq[s.charAt(j)-'a']==k) count--;
        //     System.out.println(count+"-");
        //     if(freq[s.charAt(j)-'a']==1 && freq[s.charAt(j)-'a']<k) count++;
        //     System.out.println(count+"+");
        //     j++;
        // }
        // if(count==0) max = Math.max(max, j-i);
        // return max;
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> mp = new HashMap<>();
            int unique = 0;
            int atLeastK = 0;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);

                // New character
                if (mp.get(ch) == 1) {
                    unique++;
                }

                // Character just reached k frequency
                if (mp.get(ch) == k) {
                    atLeastK++;
                }

                // Valid substring check (O(1))
                if (unique == atLeastK) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    // private static int[] solve(String str, int k) {
    //     int[]
    // }
}