class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        hashmap = { 'a': -1, 'b': -1, 'c': -1 }
        count = 0

        for i in range(len(s)):
            hashmap[s[i]] = i
            
            x = min(hashmap.values())

            if x != -1:
                count += 1 + x

        return count