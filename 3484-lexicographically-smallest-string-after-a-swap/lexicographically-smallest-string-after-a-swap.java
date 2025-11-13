class Solution {
    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for(int i=1;i<arr.length;i++) {
            if(((arr[i-1]-'0')%2==0 && (arr[i]-'0')%2==0) && arr[i-1] > arr[i]) {
                char swap = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = swap;
                break;
            } else if(((arr[i-1]-'0')%2!=0 && (arr[i]-'0')%2!=0) && arr[i-1]>arr[i]) {
                char swap = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = swap;
                break;
            }
        }
        return new String(arr);
    }
}