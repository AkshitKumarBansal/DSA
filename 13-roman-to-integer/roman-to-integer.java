class Solution {
    public int romanToInt(String s) {
        int max = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i)=='I'){
                max += 1;
            }
            else if(s.charAt(i)=='V'){
                if(i>0 && s.charAt(i-1)=='I'){
                    max += 3;
                }
                else{
                    max += 5;
                }
            }
            else if(s.charAt(i)=='X'){
                if(i>0 && s.charAt(i-1)=='I'){
                    max += 8;
                }
                else{
                    max += 10;
                }
            }
            else if(s.charAt(i)=='L'){
                if(i>0 && s.charAt(i-1)=='X'){
                    max += 30;
                }
                else{
                    max += 50;
                }
            }
            else if(s.charAt(i)=='C'){
                if(i>0 && s.charAt(i-1)=='X'){
                    max += 80;
                }
                else{
                    max += 100;
                }
            }
            else if(s.charAt(i)=='D'){
                if(i>0 && s.charAt(i-1)=='C'){
                    max += 300;
                }
                else{
                    max += 500;
                }
            }
            else if(s.charAt(i)=='M'){
                if(i>0 && s.charAt(i-1)=='C'){
                    max += 800;
                }
                else{
                    max += 1000;
                }
            }
        }
        return max;
    }
}