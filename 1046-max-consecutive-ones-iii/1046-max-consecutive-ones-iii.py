class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        
        left = right = zeroes = ones = maxLen = 0
        
        while right < len(nums):

            if nums[right] == 0:
                zeroes += 1

            if zeroes > k:
                
                if nums[left] == 0:
                    zeroes -= 1
                
                left += 1
            
            if zeroes <= k:
                maxLen = max(maxLen, right - left + 1)

            right += 1

        return maxLen