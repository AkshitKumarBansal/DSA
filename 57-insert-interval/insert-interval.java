class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr1 = new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++) {
            arr1[i][0] = intervals[i][0];
            arr1[i][1] = intervals[i][1];
        }
        arr1[intervals.length][0] = newInterval[0];
        arr1[intervals.length][1] = newInterval[1];
        int[][] arr = new int[arr1.length][2];
        Arrays.sort(arr1, (a, b) -> Integer.compare(a[0], b[0]));
        arr[0][0] = arr1[0][0];
        arr[0][1] = arr1[0][1];
        int i = 1;
        int j = 0;
        while(i<arr1.length) {
            if(arr[j][1]>=arr1[i][0]) {
                arr[j][1] = Math.max(arr1[i][1], arr[j][1]);
            } else {
                j++;
                arr[j][0] = arr1[i][0];
                arr[j][1] = arr1[i][1];
            }
            i++;
        }
        int[][] res = new int[j+1][2];
        for(int k=0;k<=j;k++) {
            res[k][0] = arr[k][0];
            res[k][1] = arr[k][1];
        }
        return res;
    }
}