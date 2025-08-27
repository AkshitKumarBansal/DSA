class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                if(count%k==0 && count>0){
                    sb.append("-");
                }
                sb.append(s.charAt(i));
                count++;
            }
        }
        return sb.reverse().toString();
    }
}