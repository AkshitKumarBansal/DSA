class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int k=0;k<=31;k++) {
            int temp = (1 << k);
            int count = 0;
            for(int i : nums) {
                if((i & temp) != 0) count++; 
            }
            if(count%3!=0) {
                result = result | temp;
            }
        }
        return result;
    }
}