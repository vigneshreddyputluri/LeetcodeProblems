class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        N = columnNumber
        
        result = ''
        
        while N > 0:
            N -= 1
            r = N % 26
            N //= 26
            result += alpha[r]
            
        return result[::-1]