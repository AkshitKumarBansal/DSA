class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, int[]> map = new HashMap<>();
        int max = -1;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            int[] arr = map.get(ch);
            if(arr != null) {
                arr[1] = i;
                if(arr[1]!=-1) max = Math.max(arr[1]-arr[0]-1, max);
            }
            else map.put(ch, new int[]{i, -1});
        }
        return max;
    }
}