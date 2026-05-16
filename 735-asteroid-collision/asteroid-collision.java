class Solution {
    public int[] asteroidCollision(int[] arr) {
        int topIndex = -1;
        for(int a : arr) {
            if(a < 0) {
                while(topIndex >= 0 && arr[topIndex] > 0 && arr[topIndex] < -a) topIndex--;
                if(topIndex < 0 || (topIndex >= 0 && arr[topIndex] < 0)) arr[++topIndex] = a;
                if(topIndex>=0 && arr[topIndex] == -a) topIndex--;
            } else {
                arr[++topIndex] = a;
            }
        }
        return Arrays.copyOfRange(arr, 0, topIndex+1);
    }
}