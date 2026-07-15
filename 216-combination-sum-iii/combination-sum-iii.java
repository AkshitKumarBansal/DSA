class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        solve(result, arr, 0, k, n, new ArrayList<>(), 0);
        return result;
    }
    private void solve(List<List<Integer>> result, int[] arr, int ind, int k, int n, List<Integer> list, int sum) {
        if(list.size() == k) {
            System.out.println("Reached size k: " + list + ", Sum : " + sum);
            if(sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(ind == arr.length) return;
        list.add(arr[ind]);
        solve(result, arr, ind+1, k, n, list, sum + arr[ind]);
        list.remove(list.size()-1);
        solve(result, arr, ind+1, k, n, list, sum);

    }
}