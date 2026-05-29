class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> prevMap = new HashMap<>();
        for(int pos = 0; pos < nums.length;pos++){
            int num = nums[pos];
            int diff = target - num;
            
            if(prevMap.containsKey(diff)){
                return new int[]{prevMap.get(diff), pos};
            }
            prevMap.put(num,pos);
        }
        return new int[]{};
    }
}
