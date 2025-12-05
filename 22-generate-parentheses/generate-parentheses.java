class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> list = new ArrayList<>();
       solve(n, list, 0, 0, new StringBuilder());
       return list; 
    }
    private void solve(int n, List<String> list, int i, int j , StringBuilder sb) {
        if(sb.length() == n*2) {
            list.add(sb.toString());
            return;
        }
        if(i<n) {
            sb.append('(');
            solve(n, list, i+1, j, sb);
            sb.setLength(sb.length()-1);
        }
        if(j<i) {
            sb.append(')');
            solve(n, list, i, j+1, sb);
            sb.setLength(sb.length()-1);
        }
    }
}