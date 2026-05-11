class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int total = 0;
        for(int d : distance)
            total += d;
        int path = 0;
        for(int i = start; i < destination; i++) {
            path += distance[i];
        }
        return Math.min(path, total - path);
    }
}