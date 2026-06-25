class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        if(n>12 || n<4) return result;
        solve(s, result, 0, "", 1);
        return result;
    }
    private void solve(String s, List<String> result, int ind, String str, int parts) {
        int n = s.length();
        if(parts == 5) {
            if(ind == n) {
                result.add(str.substring(0, str.length() - 1));
            }
            return;
        }
        if(ind+1 <= n) {
            solve(s, result, ind+1, str + s.substring(ind, ind+1)+".", parts+1);
        }
        if(ind+2 <= n && check(s.substring(ind, ind+2))) {
            solve(s, result, ind+2, str + s.substring(ind, ind+2)+".", parts+1);
        }
        if(ind+3 <= n && check(s.substring(ind, ind+3))) {
            solve(s, result, ind+3, str + s.substring(ind, ind+3)+".", parts+1);
        }
    } 
    private boolean check(String str) {
        if(Integer.parseInt(str)>255 || str.charAt(0)=='0') return false;
        return true;
    }
}