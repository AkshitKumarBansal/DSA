class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for(String s : operations) {
            if(s.equals("X--") || s.equals("--X")) val--;
            else val++;
        }    
        return val;
    }
}