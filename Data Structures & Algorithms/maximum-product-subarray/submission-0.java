class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int prefix = 0, suffix = 0;
        int res = nums[0];

        for (int pos = 0; pos < len; pos++) {
            prefix = nums[pos] * (prefix == 0 ? 1 : prefix);
            suffix = nums[len - 1 - pos] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
