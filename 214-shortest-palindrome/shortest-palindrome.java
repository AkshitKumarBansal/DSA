class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()==0 || s==null) return "";
        int len = getLongestPalindromicPrefix(s);
        System.out.println(len);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= len; i--) {
            System.out.println(s.charAt(i));
            sb.append(s.charAt(i));
        }
        return sb.toString() + s;
    }

    public int getLongestPalindromicPrefix(String s) {
        if (s == null || s.length() == 0) return 0;

        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = new int[combined.length()];
        int prefixLen = 0;
        int i = 1;

        while (i < combined.length()) {
            if (combined.charAt(i) == combined.charAt(prefixLen)) {
                prefixLen++;
                lps[i] = prefixLen;
                i++;
            } else {
                if (prefixLen != 0) {
                    prefixLen = lps[prefixLen - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[combined.length() - 1];
    }
}