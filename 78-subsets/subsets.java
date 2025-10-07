class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Subset(0, nums, res, new ArrayList<>());
        return res;
    }
    private static void Subset(int ind, int[] arr, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++){
            list.add(arr[i]);
            Subset(i+1, arr, res, list);
            list.remove(list.size()-1);
        }
    }
}