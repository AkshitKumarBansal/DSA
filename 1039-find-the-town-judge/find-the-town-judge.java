class Solution {
    public int findJudge(int n, int[][] trust) {
        int N = trust.length;
        if(n==1) return 1;
        if(N==0 && n!=1) return -1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) set.add(trust[i][0]);
        int x = -1;
        for(int i=1;i<=n;i++) if(!set.contains(i)) x = i;
        for(int i=0;i<N;i++) {
            if(!map.containsKey(trust[i][0])) map.put(trust[i][0], trust[i][1]);
            else {
                if(map.get(trust[i][0])!=x) map.put(trust[i][0], trust[i][1]);
            }
        }
        for(int i : map.values()) if(i!=x) return -1;
        return x;
    }
}