class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        
        l = k - 1
        r = len(cardPoints) 
        maxPoints = sum(cardPoints[:k])
        Psum = maxPoints

        while (l >= 0):
          
          Psum -= cardPoints[l]
          l -= 1
          r -= 1
          Psum += cardPoints[r]

          maxPoints = max(maxPoints, Psum)

        return maxPoints