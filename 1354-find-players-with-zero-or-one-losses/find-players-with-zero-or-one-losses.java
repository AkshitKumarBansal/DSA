class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winner = new HashMap<>();
        Map<Integer, Integer> loser = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = matches.length;
        for(int i=0;i<n;i++) {
            winner.put(matches[i][0], winner.getOrDefault(matches[i][0], 0)+1);
            loser.put(matches[i][1], loser.getOrDefault(matches[i][1], 0)+1);
            set.add(matches[i][0]);
            set.add(matches[i][1]);
        }
        for(Map.Entry<Integer, Integer> entry : loser.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        for(int s:set) {
            if(!loser.containsKey(s)) noLose.add(s);
            else {
                if(loser.get(s)==1) oneLose.add(s);
            }
        }
        Collections.sort(noLose);
        Collections.sort(oneLose);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(noLose));
        result.add(new ArrayList<>(oneLose));
        return result;
    }
}