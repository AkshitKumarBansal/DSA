class Solution {
    public String[] findWords(String[] words) {
        int[] row = new int[26]; // a-z
        for (char c : "qwertyuiop".toCharArray()) row[c - 'a'] = 1;
        for (char c : "asdfghjkl".toCharArray()) row[c - 'a'] = 2;
        for (char c : "zxcvbnm".toCharArray()) row[c - 'a'] = 3;

        List<String> result = new ArrayList<>();
        outer:
        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            int r = row[chars[0] - 'a'];

            for (char c : chars) {
                if (row[c - 'a'] != r) continue outer;
            }
            result.add(word);
        }
        return result.toArray(new String[0]);
    }
}