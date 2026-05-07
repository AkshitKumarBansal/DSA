class Solution {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int num : nums) {
            graph.put(num, new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] % nums[i] == 0) {
                    graph.get(nums[i]).add(nums[j]);
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int num : nums) {
            List<Integer> curr = dfs(num, graph);
            if(curr.size() > answer.size()) {
                answer = curr;
            }
        }
        return answer;
    }
    private List<Integer> dfs(int node, Map<Integer, List<Integer>> graph) {
        if(memo.containsKey(node)) {
            return memo.get(node);
        }
        List<Integer> best = new ArrayList<>();
        for(int next : graph.get(node)) {
            List<Integer> temp = dfs(next, graph);
            if(temp.size() > best.size()) {
                best = temp;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(node);
        result.addAll(best);
        memo.put(node, result);
        return result;
    }
}

// First Create a graph from the array then find the longest depth using dfs
// Time Complexity -> O(nlogn) + O(n^2) + O(2^n) = O(2^n)
// Space Complexity -> O(n)(recursive stack) + O(n^2)(graph) = O(n^2)
// Optimize the code now time complexity -> O(n^2)