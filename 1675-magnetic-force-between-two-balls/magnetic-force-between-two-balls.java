class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        if(m == 2) return position[position.length-1]-position[0];
        int i = 1;
        int j = position[position.length-1]-position[0];
        int ans = 0;
        while(i<=j) {
            int mid = (j-i)/2 + i;
            if(Count(position, mid, m)) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
    private boolean Count(int[] arr, int x, int k) {
        int count = 1;
        int min = arr[0];
        for(int i=1;i<arr.length;i++) {
            if(arr[i]-min >= x) {
                count++;
                min = arr[i];
                if(count == k) return true;
            }
        }
        return false;
    }
}