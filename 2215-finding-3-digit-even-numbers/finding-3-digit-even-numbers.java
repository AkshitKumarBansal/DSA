class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        int n = digits.length;
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        solve(digits, visited, set, sb);
        int i = 0;
        int[] ans = new int[set.size()];
        for(int num : set) {
            ans[i++] = num;
        }
        Arrays.sort(ans);
        return ans;
    }
    private void solve(int[] arr, boolean[] visited, Set<Integer> set, StringBuilder sb) {
        if(sb.length()==3) {
            int isEven = sb.charAt(sb.length()-1)-'0';
            int num = Integer.parseInt(sb.toString());
            if(isEven%2==0) {
                set.add(num);
            }
            return;
        }
        for(int i=0;i<arr.length;i++) {
            if(visited[i]) continue;
            if(i>0 && arr[i]==arr[i-1] && !visited[i-1]) continue;
            if(sb.length() == 0 && arr[i] == 0) continue;
            visited[i] = true;
            sb.append(arr[i]);
            solve(arr, visited, set, sb);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}