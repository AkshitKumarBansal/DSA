class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] freq = new int[10];
        for(int i=0;i<secret.length();i++) {
            if(secret.charAt(i)==guess.charAt(i)) A++;
            else {
                if(freq[secret.charAt(i)-'0']<0) B++;
                if(freq[guess.charAt(i)-'0']>0) B++;
                freq[secret.charAt(i)-'0']++;
                freq[guess.charAt(i)-'0']--;
            }
        }
        return A+"A"+B+"B";
    }
}