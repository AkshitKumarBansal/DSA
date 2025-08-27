class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String str : arr){
            char[] ch = str.toCharArray();
            int left = 0;
            int right = ch.length-1;
            while(left < right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
            result.append(new String(ch)).append(" ");
        }
        return result.toString().trim();
    }
}