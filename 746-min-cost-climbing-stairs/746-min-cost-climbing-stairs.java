class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int last = 0, lastSecond = 0;
        for (int i = 0; i < cost.length; i++) {
            int curr = cost[i] + Math.min(last, lastSecond);
            lastSecond = last;
            last = curr;
        }
        return Math.min(last, lastSecond);
    }
}