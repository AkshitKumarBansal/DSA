class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subSet(0, nums, res, new ArrayList<>());
        return res;
    }
    private static void subSet(int ind, int[] arr, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            subSet(i+1, arr, res, list);
            list.remove(list.size()-1);
        }
    }
}