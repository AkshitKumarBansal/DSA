class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    private void combinations(List<List<Integer>> res, List<Integer> list, int k, int n, int ind) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<=n;i++) {
            list.add(i);
            combinations(res, list, k, n, i+1);
            list.remove(list.size()-1);
        }
    }
}