class Solution {
    public int missingNumber(int[] nums) {
        int numsArrayLength = nums.length;
        int missedNumber = numsArrayLength;

        for (int pos = 0; pos < numsArrayLength; pos++) {
            missedNumber ^= pos ^ nums[pos];
        }

        return missedNumber;
    }
}
