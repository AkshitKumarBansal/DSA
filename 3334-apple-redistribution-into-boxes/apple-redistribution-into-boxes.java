class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int num : apple) sum+=num;
        int cap = 0;
        Arrays.sort(capacity);
        for(int i=capacity.length-1;i>=0;i--) {
            if(cap<sum) cap += capacity[i];
            if(cap>=sum) return capacity.length-i;
        }
        return -1;
    }
}