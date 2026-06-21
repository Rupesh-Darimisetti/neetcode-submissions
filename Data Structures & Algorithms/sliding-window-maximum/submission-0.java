class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];

        for (int pos = 0; pos <= len - k; pos++) {
            int max = nums[pos];
            for (int ele = pos; ele < pos + k; ele++) {
                max = Math.max(max, nums[ele]);
            }
            res[pos] = max;
        }
        return res;
    }
}
