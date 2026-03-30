class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();

        // Outer loop: Every possible starting position
        for (int i = 0; i < n; i++) {
            Set<Character> seenVowels = new HashSet<>();
            
            // Inner loop: Expand the substring from i to j
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                
                if (isVowel(c)) {
                    seenVowels.add(c);
                    // If the set contains all 5 unique vowels, it's a valid substring
                    if (seenVowels.size() == 5) {
                        count++;
                    }
                } else {
                    // If we hit a consonant, no more substrings starting at 'i' can be valid
                    break;
                }
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}