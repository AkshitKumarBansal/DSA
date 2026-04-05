class Solution {
    public boolean judgeCircle(String moves) {
        int s = 0;
        int u = 0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                u++;
            }
            else if(moves.charAt(i)=='D'){
                u--;
            }
            else if(moves.charAt(i)=='L'){
                s++;
            }
            else if(moves.charAt(i)=='R'){
                s--;
            }
        }
        return s==0 && u==0;
    }
}