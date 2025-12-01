class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];
        int sum = 0;
        if(k==0) return arr;
        if(k>0) {
            for(int i=1;i<=k;i++) {
                if(i<code.length) {
                    sum += code[i];
                } else {
                    sum += code[i-code.length];
                }
            }
        } else if(k<0) {
            for(int i=code.length-1;i>=code.length+k;i--) {
                if(i<code.length) {
                    sum += code[i];
                } else {
                    sum += code[i-code.length];
                }
            }
        }
        arr[0] = sum;
        if(k>0) {
            int i = 1;
            int j = k+1;
            while(j<code.length+k) {
                if(j<code.length) {
                    sum = sum - code[i] + code[j];
                } else {
                    sum = sum - code[i] + code[j-code.length];
                }
                arr[i] = sum;
                i++;
                j++;
            }
        } else if(k<0) {
            int i = 1;
            int j = k;
            while(i<code.length) {
                if(j<0) {
                    sum = sum + code[i-1] - code[j+code.length];
                } else {
                    sum = sum + code[i-1] - code[j];
                }
                arr[i] = sum;
                i++;
                j++;
            }
        }
        return arr;
    }
}