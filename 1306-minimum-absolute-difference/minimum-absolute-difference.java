class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            diff = Math.min(arr[i+1]-arr[i], diff);
        }
        for(int i=0;i<n-1;i++) {
            if(diff == arr[i+1]-arr[i]) {
                result.add(new ArrayList<>(Arrays.asList(arr[i], arr[i+1])));
            }
        }
        return result;
    }
}