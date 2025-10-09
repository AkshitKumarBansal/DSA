class Solution {
    public long countVowels(String word) {
        long count = 0;
        long n = word.length();
        for (int start = 0; start < n; start++) {
            if("aeiouAEIOU".indexOf(word.charAt(start)) != -1) {
                count += (start+1)*(n-start);
            }
        }
        return count;
    }
}
