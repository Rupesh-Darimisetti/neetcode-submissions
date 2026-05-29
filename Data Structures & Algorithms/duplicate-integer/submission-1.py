class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums.sort()
        for ele in range(1,len(nums)):
            if (nums[ele - 1] == nums[ele]):
                return True
        return False

         