class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int possibleAns) {
        int count = 0;
        for (int day : bloomDay) {
            if (day <= possibleAns) count++;
            else count = 0;
            if (count == k) {
                m--;
                count = 0;
            }
        }
        return m <= 0;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            if (day < left) left = day;
            if (day > right) right = day;
        }
        
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        
        return ans;
    }
}