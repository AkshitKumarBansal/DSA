class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        subSequence(0, candidates, target, res, new ArrayList<>());
        return res;         
    }
    private static void subSequence(int ind, int[] arr, int target, List<List<Integer>> res, List<Integer> list) {
        if(ind == arr.length) {
            if(target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[ind] <= target) {
            list.add(arr[ind]);
            subSequence(ind, arr, target-arr[ind], res, list);
            list.remove(list.size()-1);
        }
        subSequence(ind+1, arr, target, res, list);
    }
}