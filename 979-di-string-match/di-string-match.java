class Solution {
    public int[] diStringMatch(String s) {
        int[] arr = new int[s.length()+1];
        int x=0;
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                if(s.charAt(x)=='I'){
                    if(arr[j]<arr[i]){
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                } else {
                    if(arr[j]>arr[i]){
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
            x++;
        }
        // x = s.length()-1;
        // for(int i=arr.length-1;i>0;i--){
        //     if(s.charAt(x)=='I'){
        //         if(arr[i]<arr[i-1]){
        //             int temp = arr[i];
        //             arr[i] = arr[i-1];
        //             arr[i-1] = arr[i];
        //         }
        //     } else {
        //         if(arr[i]>arr[i-1]){
        //             int temp = arr[i];
        //             arr[i] = arr[i-1];
        //             arr[i-1] = temp;
        //         }
        //     }
        //     x--;
        // }
        return arr;
    }
}