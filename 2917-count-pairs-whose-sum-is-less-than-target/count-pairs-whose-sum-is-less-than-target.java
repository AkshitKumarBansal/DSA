class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int count = 0;
        for(int i=0;i<n;i++) {
            int num = target - nums.get(i);
            int l = i+1, r = n-1, pos = i;
            while(l<=r) {
                int mid = (r+l)/2;
                if(nums.get(mid)<num) {
                    pos = mid;
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
            count += pos-i;
        }
        return count;
    }
}