class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(Character.isLetter(arr[left]) && Character.isLetter(arr[right])){
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }else if(Character.isLetter(arr[left]) && !Character.isLetter(arr[right])){
                right--;
            }else if(!Character.isLetter(arr[left]) && Character.isLetter(arr[right])){
                left++;
            }
            else{
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}