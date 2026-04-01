class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) boxed[i] = arr[i];

        Arrays.sort(boxed, (a, b) -> {
            int diff = Integer.bitCount(a) - Integer.bitCount(b);
            return diff != 0 ? diff : a - b;
        });

        for (int i = 0; i < arr.length; i++) arr[i] = boxed[i];
        return arr;
    }
}