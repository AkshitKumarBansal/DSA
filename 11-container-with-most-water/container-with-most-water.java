class Solution {
    public int maxArea(int[] height) {
        int max_height = 0;
        int s = 0;
        int e = height.length-1;
        while(s<e){
            int width = e-s;
            int min_height = Math.min(height[s],height[e]);
            int max = width*min_height;
            max_height = Math.max(max_height, max);
            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return max_height;
    }
}