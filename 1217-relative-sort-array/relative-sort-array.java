class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int n : arr2) {
            map.put(n, 0);
        }
        List<Integer> list = new ArrayList<>();
        for(int n : arr1) {
            if(map.containsKey(n)) map.put(n, map.get(n)+1);
            else list.add(n);
        }
        Collections.sort(list);
        int n = arr1.length;
        int[] ans = new int[n];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            while(value!=0) {
                ans[i++] = key;
                value--;
            }
        }
        for(int j=0;j<list.size();j++) {
            ans[i++] = list.get(j);
        }
        return ans;
    }
}