public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int pos = 0; pos < nums.length; pos++) {
            if (nums[pos] > 0) break;
            if (pos > 0 && nums[pos] == nums[pos - 1]) continue;

            int left = pos + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[pos] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[pos], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}