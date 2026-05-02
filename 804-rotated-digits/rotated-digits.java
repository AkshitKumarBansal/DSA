class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=1;i<=n;i++) {
            int num = i;
            boolean flag = true;
            int count1 = 0;
            int count2 = 0;
            while(num!=0) {
                int rem = num%10;
                if(rem==3 || rem==4 || rem==7) flag = false;
                else if(rem==0 || rem==1 || rem==8) count1++;
                else count2++;
                num /= 10;
            }
            if(flag) {
                if(count2>0) {
                    count++;
                }
            }
        }
        return count;
    }
}