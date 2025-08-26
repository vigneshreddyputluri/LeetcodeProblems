class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        count = 0
        hashmap = { 0: 1 }
        prefSum = 0

        for num in nums:
            prefSum += num % 2

            hashmap[prefSum] = 1 + hashmap.get(prefSum, 0)

            count += hashmap.get(prefSum - k, 0)

        return count