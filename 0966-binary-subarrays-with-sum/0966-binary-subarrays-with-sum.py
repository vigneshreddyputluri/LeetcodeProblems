class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        def func(nums: List[int], goal: int) -> int:
            l = 0
            r = 0
            sum = 0
            count = 0

            while (r < len(nums)):
                sum += nums[r]

                while (sum > goal and l <= r):
                    sum -= nums[l]
                    l += 1

                if sum <= goal:
                    count += r - l + 1

                r += 1

            return count

        return func(nums, goal) - func(nums, goal - 1)