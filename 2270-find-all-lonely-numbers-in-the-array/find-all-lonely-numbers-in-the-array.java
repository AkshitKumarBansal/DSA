class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            set.add(n);
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int n : nums) {
            if(map.get(n)==1 && !set.contains(n-1) && !set.contains(n+1)) list.add(n);
        }
        return list;
    }
}