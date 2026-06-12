class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }
}
