class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] p : pieces) {
            map.put(p[0], p);
        }
        int i=0;
        while(i<arr.length) {
            if(!map.containsKey(arr[i])) return false;
            int[] p = map.get(arr[i]);
            for(int j=0;j<p.length;j++) {
                if(i >= arr.length || arr[i]!=p[j]) return false;
                i++;
            }
        }
        return true;
    }
}