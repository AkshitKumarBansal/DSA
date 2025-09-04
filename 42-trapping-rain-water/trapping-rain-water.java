class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        if (len == 0) return 0;
        lmax[0] = height[0];
        for(int i=1; i<len; i++) {
            lmax[i] = Math.max(height[i], lmax[i-1]);
        } 
        rmax[len - 1] = height[len - 1];
        for(int i=len-2; i>=0; i--) {
            rmax[i] = Math.max(height[i], rmax[i+1]);
        }
        int ans = 0;
        for(int i=0; i<len; i++) {
            ans += (Math.min(lmax[i], rmax[i]) - height[i]);
        }
        return ans;
    }
}