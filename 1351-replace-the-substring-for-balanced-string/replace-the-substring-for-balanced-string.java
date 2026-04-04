class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int Q = 0, W = 0, R = 0, E = 0;
        for(char c : s.toCharArray()) {
            if(c == 'Q') Q++;
            else if(c == 'W') W++;
            else if(c == 'R') R++;
            else E++;
        }
        int count = n/4;
        if((Q==W && W==R && R==E)) return 0;
        int left = 0;
        int minLen = n;
        for(int right=0;right<n;right++) {
            char ch = s.charAt(right);
            if(ch == 'Q') Q--;
            else if(ch == 'W') W--;
            else if(ch == 'R') R--;
            else E--;
            while (left < n && Q <= count && W <= count && R <= count && E <= count) {
                minLen = Math.min(minLen, right - left + 1);
                char cLeft = s.charAt(left);
                if (cLeft == 'Q') Q++;
                else if (cLeft == 'W') W++;
                else if (cLeft == 'R') R++;
                else E++;

                left++;
            }
        }
        return minLen;
    }
}