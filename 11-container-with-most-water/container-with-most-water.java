class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0,j=n-1;
        int area = 0;
        while(i<j) {
            area = Math.max(area, (j-i)*Math.min(height[j],height[i]));
            if(height[j]<height[i]) j--;
            else i++;
        }
        return area;
    }
}