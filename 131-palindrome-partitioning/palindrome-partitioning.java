class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        palindrome(0, s, res, new ArrayList<>());
        return res;
    }
    private static void palindrome(int ind, String str, List<List<String>> res, List<String> list) {
        if(ind == str.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<str.length();i++) {
            if(check(str.substring(ind, i+1))){
                list.add(str.substring(ind, i+1));
                palindrome(i+1, str, res, list);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean check(String str) {
        int left = 0;
        int right = str.length()-1;
        while(left<=right) {
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}