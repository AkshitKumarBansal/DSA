class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = null;
        int[] arr = new int[26];
        for(int i=0;i<licensePlate.length();i++){
            if(Character.isLetter(licensePlate.charAt(i))){
                arr[Character.toLowerCase(licensePlate.charAt(i))-'a']++;
            }
        }
        for(String word : words){
            if(isEquals(arr, word)){
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
    private boolean isEquals(int arr1[], String str2){
        int arr2[] = new int[26];
        for(int i=0;i<str2.length();i++){
            arr2[Character.toLowerCase(str2.charAt(i))-'a']++;
        } 
        for(int i=0;i<26;i++){
            if(arr1[i] > arr2[i]){
                return false;
            }
        }
        return true;
    }
}