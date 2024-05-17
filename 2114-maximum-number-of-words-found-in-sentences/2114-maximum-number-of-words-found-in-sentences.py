class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        maxi = len(sentences[0].split())
        for i in range(1, len(sentences)):
            maxi = max(maxi, len(sentences[i].split()))
                
        return maxi