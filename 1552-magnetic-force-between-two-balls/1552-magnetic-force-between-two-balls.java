class Solution {
    public boolean isPossible(int[] position, int m, int mid) {
        int lastPos = position[0] - mid;
        for (int pos : position) {
            if (pos - lastPos >= mid) {
                m--;
                lastPos = pos;
            }
        }
        return m <= 0;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(position, m, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}