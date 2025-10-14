class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        permutations(nums, set, 0);
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
    private static void permutations(int[] arr, Set<List<Integer>> set, int ind) {
        if(ind==arr.length) {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++) {
                list.add(arr[i]);
            }
            set.add(new ArrayList<>(list));
        }
        for(int i=ind;i<arr.length;i++) {
            swap(ind, i, arr);
            permutations(arr, set, ind+1);
            swap(ind, i, arr);
        }
    }
    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}