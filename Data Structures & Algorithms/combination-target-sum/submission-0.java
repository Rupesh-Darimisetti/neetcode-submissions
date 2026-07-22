class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> curr, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int pos = i; pos < nums.length; pos++) {
            if (total + nums[pos] > target) {
                return;
            }
            curr.add(nums[pos]);
            dfs(pos, curr, total + nums[pos], nums, target);
            curr.remove(curr.size() - 1);
        }
    }
}
