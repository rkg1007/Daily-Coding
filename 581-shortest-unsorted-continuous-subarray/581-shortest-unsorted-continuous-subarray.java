class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        int start = n;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i+1]) {
                int key = nums[i+1];
                start = Math.min(start, i);
                while (start >= 0 && nums[start] > key) {
                    start--;
                }
            }
        }
        
        int end = start;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < nums[i-1]) {
                int key = nums[i - 1];
                end = Math.max(end, i);
                while (end < n && nums[end] < key) {
                    end++;
                }
            }
        }
        
        return start == n ? 0 : end - start - 1;
    }
}