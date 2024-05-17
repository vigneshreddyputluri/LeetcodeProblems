class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        maxi = len(sentences[0].split())
        for i in range(len(sentences)):
            if maxi < len(sentences[i].split()):
                maxi = len(sentences[i].split())
                
        return maxi