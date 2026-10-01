class Solution {
    public int uniquePaths(int m, int n) {
        // only 1 path
        if (m == 1 || n == 1) {
            return 1;
        }
        // Choose smaller value to reduce calculation
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        long res = 1;
        int j = 1;
        for (int i = m; i < m + n - 1; i++) {
            res *= i;
            res /= j;
            j++;
        }
        return (int) res;
    }
}
