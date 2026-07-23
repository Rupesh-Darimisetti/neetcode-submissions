class Solution {
    private static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private static void dfs(int index, List<Integer> path, int current, int[] candidates, int target) {
        if (current == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int pos = index; pos < candidates.length; pos++) {
            if (pos > index && candidates[pos] == candidates[pos - 1]) {
                continue;
            }
            if (current + candidates[pos] > target) {
                break;
            }
            path.add(candidates[pos]);
            dfs(pos + 1, path, current + candidates[pos], candidates, target);
            path.remove(path.size() - 1);
        }
    }
}
