class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for(int i=0;i<bookings.length;i++) {
            int start = bookings[i][0]-1;
            int end = bookings[i][1]-1;
            int seats = bookings[i][2];
            arr[start] += seats;
            if(end+1<n) arr[end+1] -= seats;
        }
        for(int i=1;i<n;i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}