class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for idx in range(len(nums)):
            if target - nums[idx] in dic:
                return [dic[target - nums[idx]], idx]
            dic[nums[idx]] = idx
            