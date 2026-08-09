class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int len = intervals.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int pos = 1; pos < len; pos++) {
            int index = bs(pos, intervals[pos][0], intervals);
            if (index == 0) {
                dp[pos] = dp[pos - 1];
            } else {
                dp[pos] = Math.max(dp[pos - 1], 1 + dp[index - 1]);
            }
        }
        return len - dp[len - 1];
    }
    private int bs(int right, int target, int[][] intervals) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (intervals[mid][1] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
