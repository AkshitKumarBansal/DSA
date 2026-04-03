class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(int i=0;i<tickets.size();i++) {
            String from = tickets.get(i).get(0);
            String to   = tickets.get(i).get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(to);
        }
        dfs(result, map, "JFK");
        Collections.reverse(result);
        return result;
    }
    private void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String s) {
        PriorityQueue<String> pq = map.get(s);
        while(pq != null && !pq.isEmpty()) {
            dfs(result, map, pq.poll());
        }
        result.add(s);
    }
}