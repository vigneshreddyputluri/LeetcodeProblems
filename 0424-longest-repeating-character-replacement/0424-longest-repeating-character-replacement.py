class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        # initialization of left, maxRepLen, dict
        left = 0
        maxRepLen = maxRep = 0
        hashmap = dict()
        
        # iterating right so that mana presentLen - k should be 
        for right in range(len(s)):

            hashmap[s[right]] = 1 + hashmap.get(s[right], 0)
            maxRep = max(maxRep, hashmap[s[right]])

            while (right - left + 1) - maxRep > k:
                hashmap[s[left]] -= 1
                left += 1
            
            maxRepLen = max(maxRepLen, right - left + 1)

        return maxRepLen