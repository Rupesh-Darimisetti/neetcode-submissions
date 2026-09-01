class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacent = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for (int index = 0; index < n; index++) {
            adjacent.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(adjacent, visit, node);
                res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> adjacent, boolean[] visit, int node) {
        visit[node] = true;
        for (int neighbour : adjacent.get(node)) {
            if (!visit[neighbour]) {
                dfs(adjacent, visit, neighbour);
            }
        }
    }
}
