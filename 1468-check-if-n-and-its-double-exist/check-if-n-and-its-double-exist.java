class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int x : arr) {
            if(x==0 && set.contains(0)) return true;
            set.add(x);
        }
        for(int x : arr) if(set.contains(2*x) && x!=0) return true;
        return false;
    }
}