class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while(i < n) {
            int lettersCount = words[i].length();
            int j = i+1;
            int gaps = 0;
            while(j < n && words[j].length() + 1 + gaps + lettersCount <= maxWidth) {
                lettersCount += words[j].length();
                gaps += 1;
                j++;
            }
            int remainingSpaces = maxWidth - lettersCount;
            int eachSpaceGap = gaps==0 ? 0 : remainingSpaces / gaps;
            int extraSpaceGap = gaps==0 ? 0 : remainingSpaces % gaps;
            if(j == n) {
                eachSpaceGap = 1;
                extraSpaceGap = 0;
            }
            result.add(solve(i, j, eachSpaceGap, extraSpaceGap, words, maxWidth));
            i = j;
        }
        return result;
    }
    private String solve(int i, int j, int each, int extra, String[] words, int maxWidth) {
        String s = "";
        for(int k=i; k<j; k++) {
            s += words[k];
            if(k == j-1) continue;
            for(int z=1; z<=each; z++) {
                s += " ";
            }
            if(extra > 0) {
                s += " ";
                extra--;
            }
        }
        while(s.length() < maxWidth) {
            s += " ";
        }
        return s;
    }
}