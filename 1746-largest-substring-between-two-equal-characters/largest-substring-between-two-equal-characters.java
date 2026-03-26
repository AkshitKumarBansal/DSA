class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int max = -1;
        for(int i=0;i<s.length();i++) {
            int j = s.charAt(i)-'a';
            if(arr[j]==-1) arr[j] = i;
            else max = Math.max(max, i-arr[j]-1);
        }
        return max;
    }
}