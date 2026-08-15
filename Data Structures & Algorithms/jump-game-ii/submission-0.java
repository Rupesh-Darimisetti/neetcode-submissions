class Solution {
    public int jump(int[] nums) {
        int result = 0, left = 0, right = 0;

        while (right < nums.length - 1) {
            int farthest = 0;
            
            for (int position = left; position <= right; position++) {
                farthest = Math.max(farthest, position + nums[position]);
            }
            
            left = right + 1;
            right = farthest;
            result++;
        }

        return result;
    }
}
