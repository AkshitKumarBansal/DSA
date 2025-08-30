class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        int costSum=0;
        for(int i=0;i<gas.length;i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum) return -1;
        int start=0,curr=0;
        for(int i=0;i<gas.length;i++){
            curr += (gas[i]-cost[i]);
            if(curr < 0){
                start=i+1;
                curr=0;
            }
        }
        return start;
    }
}