class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashmap = { 0: 1 }
        preSum = 0
        count = 0 

        for num in nums:
            preSum += num
            count += hashmap.get(preSum-k, 0)
            hashmap[preSum] = 1 + hashmap.get(preSum, 0)

        return count