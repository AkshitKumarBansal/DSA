class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder(number);
        List<String> list = new ArrayList<>();
        for(int i=0;i<number.length();i++) {
            if(sb.charAt(i)==digit) {
                sb.deleteCharAt(i);
                list.add(sb.toString());
                sb = new StringBuilder(number); 
            }
        }
        String max = list.get(0);
        for(int i=0;i<list.size();i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return String.valueOf(max);
    }
}