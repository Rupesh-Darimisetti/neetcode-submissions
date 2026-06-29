class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> ele = new HashSet<>();
        for (int num : nums) {
            if (ele.contains(num)) {
                return num;
            }
            ele.add(num);
        }
        return -1;
    }
}
