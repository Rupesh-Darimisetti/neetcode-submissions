class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int len = numbers.length;
        Map<Integer, Integer> numPos = new HashMap<>();
        for (int pos = 0; pos < len; pos++) {
            numPos.put(numbers[pos], pos);
        }
        for (int pos = 0; pos < len; pos++) {
            int diff = target - numbers[pos];
            if (numPos.containsKey(diff) && numPos.get(diff) != pos) {
                return new int[] {pos + 1, numPos.get(diff) + 1};
            }
        }
        return res;
    }
}
