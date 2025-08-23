class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        
        hashmap = {0: 1}
        prefSum = 0
        count = 0

        for num in nums:
            prefSum += num
            
            count += hashmap.get(prefSum - goal, 0)
            
            hashmap[prefSum] = 1 + hashmap.get(prefSum, 0)

        return count