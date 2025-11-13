class Solution {
    public int splitNum(int num) {
        int num1 = 0;
        int num2 = 0;
        int digit = String.valueOf(num).length();
        int[] arr = new int[digit];
        int i = 0;
        while(num != 0) {
            arr[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(arr);
        num1 = arr[0];
        num2 = arr[1];
        for(i=2;i<arr.length-1;i+=2) {
            num1 = arr[i] + num1*10;
            num2 = arr[i+1] + num2*10;
        }
        if(i<digit) num1 = arr[i] + num1*10;
        return num1+num2;
    }
}