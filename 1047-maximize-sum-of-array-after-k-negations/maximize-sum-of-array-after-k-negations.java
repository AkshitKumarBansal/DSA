class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int neg = 0,pos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                neg++;
            }
            if(nums[i]>0){
                pos++;
            }
        } 
        int sum = 0;
        if(neg == 0) {
            if(k%2==0) {
                for(int i=0;i<nums.length;i++) {
                    sum += nums[i];
                }
            } else {
                sum -= (nums[0]*2);
                for(int i=0;i<nums.length;i++) {
                    sum += nums[i];
                }
            }
        }else if(neg >= k) {
            for(int i=0;i<nums.length;i++) {
                if(k > 0) {
                    sum += (-1*nums[i]);
                    k--;
                } else {
                    sum += nums[i];
                }
            }
        }
        else if(k > neg && ((k-neg)%2==0)) {
            for(int i=0;i<nums.length;i++) {
                if(neg > 0) {
                    sum += (-1*nums[i]);
                    neg--;
                } else {
                    sum += nums[i];
                }
            }
        }else if(k > neg && ((k-neg)%2!=0)) {
            int i = 0;
            while(neg > 1) {
                sum += (-1*nums[i++]);
                neg--;
            }
            if((i+1 < nums.length) && (nums[i]*-1)>nums[i+1]) {
                sum += (-1*nums[i]);
                sum -= nums[i+1];
                i += 2;
                while(i<nums.length) {
                    sum += nums[i];
                    i++;
                }
            } else {
                while(i<nums.length) {
                    sum += nums[i];
                    i++;
                }
            }
        }
        return sum;
    }
}