class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # initializing final result variable, left variable and required sets/dictionaries/lists
        maxLen = 0
        left = 0
        hashmap = dict()

        # iterating over the list or string with right variable
        for right in range(len(s)):
            
            # iterating with left variable checking if the right character exists in the hashset
            if (s[right] in hashmap):
                if (hashmap[s[right]] >= left):

                    # if exists, left most character is being removed from the hashset and incrementing the left variable
                    left = hashmap[s[right]] + 1
                
            # now adding up the right most  character into the hashset
            hashmap[s[right]] = right
            
            # updating the maxLength the maximum length
            maxLen = max(maxLen, right - left + 1)

        return maxLen