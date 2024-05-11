class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
                
        result = ''
        
        while columnNumber > 0:
            columnNumber -= 1
            r = columnNumber % 26
            columnNumber //= 26
            result += alpha[r]
            
        return result[::-1]