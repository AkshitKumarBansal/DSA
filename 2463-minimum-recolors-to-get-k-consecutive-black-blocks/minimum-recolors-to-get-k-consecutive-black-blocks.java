class Solution {
    public int minimumRecolors(String blocks, int k) {
        int b = 0;
        int w = 0;
        for(int i=0;i<k;i++) {
            if(blocks.charAt(i)=='B') {
                b++;
            } else {
                w++;
            }
        }
        int i = 1;
        int j = k;
        int max = b;
        while(j<blocks.length()) {
            if(blocks.charAt(i-1)=='W' && blocks.charAt(j)=='B') {
                w--;
                b++;
            } else if(blocks.charAt(i-1)=='B' && blocks.charAt(j)=='W') {
                w++;
                b--;
            }
            max = Math.max(max, b);
            i++;
            j++;
        }
        return k-max;
    }
}