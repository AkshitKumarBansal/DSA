class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        int[] arr1 = new int[52];
        for(int i=0;i<jewels.length();i++){
            if(Character.isUpperCase(jewels.charAt(i))){
                arr1[jewels.charAt(i)-'A']++;
            } else if(Character.isLowerCase(jewels.charAt(i))){
                arr1[26 + jewels.charAt(i)-'a']++;
            }
        }
        int[] arr2 = new int[52];
        for(int i=0;i<stones.length();i++){
            if(Character.isUpperCase(stones.charAt(i))){
                arr2[stones.charAt(i)-'A']++;
            } else if(Character.isLowerCase(stones.charAt(i))){
                arr2[26 + stones.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<52;i++){
            if(arr1[i]>0 && arr2[i]>0){
                cnt += arr2[i];
            }
        }
        return cnt;
    }
}