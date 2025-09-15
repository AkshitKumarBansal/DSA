class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        while(left<=right){
            int num = left;
            boolean flag = true;
            while(num!=0){
                int rem = num%10;
                num /= 10;
                if(rem == 0 || left%rem!=0){ 
                    flag = false;
                    break;
                }
            }
            if(flag) result.add(left);
            left++;
        }
        return result;
    }
}