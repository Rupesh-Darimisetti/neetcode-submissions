class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int prevIndex = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = (i >= 1 && nums[i] == nums[i - 1]) ? prevIndex : 0;
            prevIndex = res.size();
            for (int j = index; j < prevIndex; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
