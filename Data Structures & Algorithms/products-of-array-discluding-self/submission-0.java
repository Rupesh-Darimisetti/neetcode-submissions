class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;

        for (int pos = 1; pos < n; pos++) {
            pref[pos] = nums[pos - 1] * pref[pos - 1];
        }

        for (int pos = n - 2; pos >= 0; pos--) {
            suff[pos] = nums[pos + 1] * suff[pos + 1];
        }

        for (int pos = 0; pos < n; pos++) {
            res[pos] = pref[pos] * suff[pos];
        }
        return res;
    }
}
