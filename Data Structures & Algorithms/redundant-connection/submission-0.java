class Solution {
    private boolean[] visit;
    private List<List<Integer>> adjacent;
    private Set<Integer> cycle;
    private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adjacent = new ArrayList<>();
        for (int index = 0; index <= n; index++) {
            adjacent.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacent.get(u).add(v);
            adjacent.get(v).add(u);
        }
        visit = new boolean[n + 1];
        cycle = new HashSet<>();
        cycleStart=-1;
        dfs(1, -1);

        for (int index = edges.length - 1; index >= 0; index--) {
            int u = edges[index][0], v = edges[index][1];
            if (cycle.contains(u) && cycle.contains(v)) {
                return new int[] {u, v};
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if (visit[node]) {
            cycleStart = node;
            return true;
        }
        visit[node] = true;
        for (int neighbour : adjacent.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (dfs(neighbour, node)) {
                if (cycleStart != -1) {
                    cycle.add(node);
                }
                if (node == cycleStart) {
                    cycleStart = -1;
                }
            return true;
            }
        }
        return false;
    }
}
