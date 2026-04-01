class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while(l<r) {
            int mid = (r+l)/2;
            if(nums[mid]<=0) l = mid+1;
            else r = mid; 
        }
        int pos = n-l;
        l = 0; r = n;
        while(l<r) {
            int mid = (r+l)/2;
            if(nums[mid]<0) l = mid+1;
            else r = mid; 
        }
        int neg = l;
        return Math.max(pos, neg);
    }
}