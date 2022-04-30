class Solution {
    public boolean isInterLeave(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) return true;
        
        if (dp[i][j][k] == 0) {
            dp[i][j][k] = -1;
            if (i == s1.length() || s1.charAt(i) != s3.charAt(k)) {
                if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
                    dp[i][j][k] = isInterLeave(s1, s2, s3, i, j + 1, k + 1, dp) ? 1 : -1;
            } else if (j == s2.length() || s2.charAt(j) != s3.charAt(k)) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
                    dp[i][j][k] = isInterLeave(s1, s2, s3, i + 1, j, k + 1, dp) ? 1 : -1;
            } else {
                dp[i][j][k] = (isInterLeave(s1, s2, s3, i + 1, j, k + 1, dp)
                || isInterLeave(s1, s2, s3, i, j + 1, k + 1, dp)) ? 1 : -1;
            }
        }
        
        if (dp[i][j][k] == 1) return true;
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return isInterLeave(s1, s2, s3, 0, 0, 0, dp);
    }
}