class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int[] ans = {-1,-1};
        int first=-1;
        int last=-1;
        // int k = 0;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                // ans[0]=i;
                // break;
                if(first==-1){
                    first=i;
                }
                last=i;
            }
        }
        // if(ans[0]==-1){
        //     return ans;
        // }
        // for(int i=nums.length-1;i>=0;i--){
        //     if(target==nums[i]){
        //         ans[1]=i;
        //         break;
        //     }
        // }
        return new int[]{first,last};
    }
}