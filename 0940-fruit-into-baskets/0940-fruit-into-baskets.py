class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        
        left = right = maxLen = 0
        basket = {}

        while right < len(fruits):

            basket[fruits[right]] = 1 + basket.get(fruits[right], 0)

            if len(basket) > 2:

                basket[fruits[left]] -= 1

                if basket[fruits[left]] == 0:
                    basket.pop(fruits[left])

                left += 1

            if len(basket) <= 2:
                maxLen = max(maxLen, right - left + 1)

            right += 1

        return maxLen