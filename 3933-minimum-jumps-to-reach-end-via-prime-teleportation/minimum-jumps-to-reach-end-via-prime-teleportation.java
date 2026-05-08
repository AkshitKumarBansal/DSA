class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build factor -> indices map
        for (int i = 0; i < n; i++) {

            int num = nums[i];

            int temp = num;

            for (int factor = 2;
                 factor * factor <= temp;
                 factor++) {

                if (num % factor == 0) {

                    map.computeIfAbsent(factor,
                            k -> new ArrayList<>()).add(i);

                    while (num % factor == 0) {
                        num /= factor;
                    }
                }
            }

            // remaining prime factor
            if (num > 1) {

                map.computeIfAbsent(num,
                        k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(0);

        boolean[] visited = new boolean[n];

        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // left
                if (idx - 1 >= 0 &&
                    !visited[idx - 1]) {

                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // right
                if (idx + 1 < n &&
                    !visited[idx + 1]) {

                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // teleport
                if (isPrime(nums[idx])) {

                    int p = nums[idx];

                    if (map.containsKey(p)) {

                        for (int next : map.get(p)) {

                            if (!visited[next]) {

                                visited[next] = true;
                                q.offer(next);
                            }
                        }

                        // important optimization
                        map.remove(p);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}