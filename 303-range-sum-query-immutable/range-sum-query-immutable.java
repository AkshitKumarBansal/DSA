class NumArray {
    public int[] prefix;
    // public int[] suffix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        // suffix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }
        // for(int i=nums.length-1;i>=0;i--) {
        //     suffix[i] = nums[i+1] + suffix[i+1];
        // }
    }
    
    public int sumRange(int left, int right) {
        System.out.println(prefix[left] + " " +prefix[right]);
        return (left==0) ? prefix[right] : prefix[right]-prefix[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */