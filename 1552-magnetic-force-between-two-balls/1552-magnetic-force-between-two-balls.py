class Solution:
    def isPossible(self, position, m, mid):
        lastPos = position[0] - mid
        for pos in position:
            if pos - lastPos >= mid:
                m -= 1
                lastPos = pos
        return m <= 0
    
    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()
        left, right = 1, position[-1] - position[0]
        ans = -1
        while left <= right:
            mid = left + (right - left) // 2
            if self.isPossible(position, m, mid):
                left = mid + 1
                ans = mid
            else: 
                right = mid - 1
        return ans