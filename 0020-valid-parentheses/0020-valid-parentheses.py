class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        o = ['[','{','(']
        c = [']','}',')']
        for i in s:
            if i in o:
                stack.append(i)
            elif i in c:
                if o[c.index(i)] in stack:
                    if o[c.index(i)] == stack[-1]:
                        stack.pop(-1)
                else:
                    return False
        if len(stack):
            return False
        return True