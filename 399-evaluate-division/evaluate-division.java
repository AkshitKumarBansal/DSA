class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, 1.0 / wt)); 
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            // If either variable doesn't exist
            if (!adj.containsKey(src) || !adj.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(src, dest, 1.0, visited, adj);
            }
        }

        return ans;
    }
    private double dfs(String curr, String dest, double product,
                       Set<String> visited,
                       Map<String, List<Pair>> adj) {

        if (curr.equals(dest))
            return product;

        visited.add(curr);

        for (Pair next : adj.get(curr)) {

            if (!visited.contains(next.node)) {

                double result = dfs(next.node, dest,
                                    product * next.weight,
                                    visited, adj);

                if (result != -1.0)
                    return result;
            }
        }

        return -1.0;
    }
}

class Pair {
    String node;
    double weight;

    Pair(String node, double weight) {
        this.node = node;
        this.weight = weight;
    }
}