class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;
            if (citations[mid] >= h) {
                ans = h;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (ans != -1) return ans;
        return 0;
    }
}