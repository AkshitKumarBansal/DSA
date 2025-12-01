class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        boolean flag = false;
        int i = 0;
        int j = k;
        int count = 0;
        while(j<=s.length()) {
            flag = false;
            if(Integer.parseInt(s.substring(i, j)) != 0) {
                if(num%(Integer.parseInt(s.substring(i, j))) == 0) {
                    flag = true;
                }
            }
            if(flag) count++;
            i++;
            j++;
        }
        return count;
    }
}