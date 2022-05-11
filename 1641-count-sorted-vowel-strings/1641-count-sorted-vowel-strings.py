class Solution:
    def countVowelStrings(self, n: int) -> int:
        dp = [1 for _ in range(5)]
        for _ in range(2, n + 1):
            for i in range(1, 5):
                dp[i] += dp[i - 1]
        return sum(dp)