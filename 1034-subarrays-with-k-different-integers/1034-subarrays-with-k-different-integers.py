class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        def func(nums, k):
            l = 0
            r = 0
            count = 0
            hashmap = {}

            while r < len(nums):

                hashmap[nums[r]] = 1 + hashmap.get(nums[r], 0)

                while len(hashmap) > k and l < r:

                    hashmap[nums[l]] -= 1
                    if hashmap[nums[l]] == 0:
                        hashmap.pop(nums[l])
                    l += 1

                if len(hashmap) <= k:
                    count += r - l + 1

                r += 1
            
            return count 
        
        return func(nums, k) - func(nums, k - 1)
