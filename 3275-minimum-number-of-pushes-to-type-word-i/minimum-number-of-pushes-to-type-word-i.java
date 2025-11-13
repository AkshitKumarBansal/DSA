class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        int size = word.length();
        if(size <= 8) return size;
        else if(size <= 16) return 8+2*(size-8);
        else if(size <= 24) return 24+3*(size-16);
        else return 48+4*(size-24);
    }
}