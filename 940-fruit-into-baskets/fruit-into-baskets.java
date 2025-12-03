class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(j<fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);
            if(map.size()<=2) {
                j++;
            } else {
                map.put(fruits[i], map.getOrDefault(fruits[i], 0)-1);
                if(map.get(fruits[i])==0) map.remove(fruits[i]);
                i++;
                j++;
            }
            max = Math.max(max, j-i+1);
        }
        return max-1;
    }
    // private boolean Count(int[] arr, int i, int j) {
    //     Set<Integer> set = new HashSet<>();
    //     for(int k=i;k<=j;k++) {
    //         set.add(arr[k]);
    //     }
    //     return (set.size()<=2) ? true : false;
    // }
}