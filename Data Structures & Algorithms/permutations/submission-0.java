class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> perms = new ArrayList<>();
            for (int num : nums) {
                perms.add(num);
            }
            res.add(perms);
            return;
        }
        for (int pos = index; pos < nums.length; pos++) {
            swap(nums, index, pos);
            backtrack(nums, index + 1);
            swap(nums, index, pos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
