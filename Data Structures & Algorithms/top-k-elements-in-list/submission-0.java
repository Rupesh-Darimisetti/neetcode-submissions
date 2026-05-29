class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numOcc = new HashMap<>();
        for(int num:nums){
            numOcc.put(num, numOcc.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>(numOcc.keySet());
        res.sort((a, b) -> numOcc.get(b) - numOcc.get(a));
        
        int[] output = new int[k];
        for(int i = 0; i < k; i++) {
            output[i] = res.get(i);
        }
        return output;
    }
}