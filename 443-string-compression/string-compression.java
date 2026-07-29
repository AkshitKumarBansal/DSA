class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 1) return 1;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n-1; i++) {
            if(chars[i] == chars[i+1]) count++;
            else {
                if(count > 1) sb.append(chars[i]).append(count);
                else sb.append(chars[i]);
                count = 1;
            }
        }
        if(count > 1) sb.append(chars[n-1]).append(count);
        else sb.append(chars[n-1]);
        for(int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}