class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        mx = sum(accounts[0])
        for i in range(1, len(accounts)):
            mx = max(mx, sum(accounts[i]))
        return mx