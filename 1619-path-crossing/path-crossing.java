class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int i = 0, j = 0;
        set.add("0,0");
        for(int k=0;k<path.length();k++) {
            if(path.charAt(k)=='N') j++;
            else if(path.charAt(k)=='E') i++;
            else if(path.charAt(k)=='S') j--;
            else i--;
            String x = i+","+j;
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}