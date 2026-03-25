class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++) {
            map.put(arr[i], i);
            set.add(arr[i]);
        }
        int i = 1;
        for(int x : set) {
            map.put(x, i);
            i++;
        }
        int[] ans = new int[n];
        for(int j=0;j<n;j++) {
            ans[j] = map.get(arr[j]);
        }
        return ans;
    }
}