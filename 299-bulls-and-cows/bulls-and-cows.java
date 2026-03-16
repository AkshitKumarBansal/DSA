class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] freq1 = new int[10];
        int[] freq2 = new int[10];
        int i=0, j=0;
        while(i<secret.length() && j<guess.length()) {
            if(secret.charAt(i)==guess.charAt(j)) A++;
            freq1[secret.charAt(i)-'0']++;
            freq2[guess.charAt(j)-'0']++;
            i++;
            j++;
        }
        while(i<secret.length()) {
            freq1[secret.charAt(i)-'0']++;
            i++;
        }
        while(j<guess.length()) {
            freq2[guess.charAt(j)-'0']++;
            j++;
        }
        for(int k=0;k<10;k++) {
            B += Math.min(freq1[k], freq2[k]);
        }
        return A+"A"+(B-A)+"B";
    }
}