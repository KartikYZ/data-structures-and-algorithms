"""
30. Substring with Concatenation of All Words
Hard

Notes:
sliding window updates can be made more optimal – O(1)
"""

from collections import defaultdict, Counter
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        idxs = []
        l = len(s)
        n = len(words)
        w = len(words[0])

        if n * w > l:
            return idxs
        
        counter = Counter(words)
        # map_words = defaultdict(int)
        # for word in words: 
        #     map_words[word] += 1

        # check_map = Counter(s[i:i+w] for i in range(0, n*w, w))

        for i in range(l - n * w + 1): 
            # check_map = defaultdict(int)
            # for j in range(n):                      ## todo: change to O(1) sliding window (Rabin-Karp)
            #     substr = s[i + j*w:i+(j+1)*w]
            #     check_map[substr] += 1
            sub = s[i:i+n*w]
            check_map = Counter(sub[i:i+w] for i in range(0, n*w, w))
            if counter == check_map:
                idxs.append(i)

        return idxs