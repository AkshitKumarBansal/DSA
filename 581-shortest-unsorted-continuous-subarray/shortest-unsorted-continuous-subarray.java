class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0] = nums[0];
        for(int i=1;i<n;i++) {
            pref[i] = Math.max(pref[i-1], nums[i]); 
        }
        suff[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            suff[i] = Math.min(suff[i+1], nums[i]);
        }
        int left = 0;
        while(left < n && suff[left] == nums[left]) {
            left++;
        }
        if(left == n) return 0;
        int right = n - 1;
        while(right >= 0 && pref[right] == nums[right]) {
            right--;
        }
        System.out.println(left+" "+right);
        return right-left+1;
    }
}