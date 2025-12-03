class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] arr = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        arr[0][0] = intervals[0][0];
        arr[0][1] = intervals[0][1];
        int i = 1;
        int j = 0;
        while(i<intervals.length) {
            if(arr[j][1]>=intervals[i][0]) {
                //arr[j][0] = intervals[i][0];
                arr[j][1] = Math.max(intervals[i][1], arr[j][1]);
            } else {
                j++;
                arr[j][0] = intervals[i][0];
                arr[j][1] = intervals[i][1];
            }
            i++;
        }
        // if(i<intervals.length) {
        //     arr[j][0] = intervals[i][0];
        //     arr[j][1] = intervals[i][1];
        //     j++;
        // }
        int[][] res = new int[j+1][2];
        for(int k=0;k<=j;k++) {
            res[k][0] = arr[k][0];
            res[k][1] = arr[k][1];
        }
        return res;
    }
}