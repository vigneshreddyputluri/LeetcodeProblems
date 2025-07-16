class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
            
        tc, sc = {}, {}

        for i in range(len(s)):
            tc[t[i]] = 1 + tc.get(t[i], 0)
            sc[s[i]] = 1 + sc.get(s[i], 0)
        return tc == sc