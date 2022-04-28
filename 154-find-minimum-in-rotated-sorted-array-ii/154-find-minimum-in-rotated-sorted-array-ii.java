class Solution {
    public int findMin(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        if (nums[left] < nums[right]) return nums[left];
        int mid = left + (right - left) / 2;
        if (nums[mid] == nums[left]) {
            return Math.min(findMin(nums, left, mid), findMin(nums, mid + 1, right));
        } else if (nums[mid] > nums[left]) {
            return findMin(nums, mid + 1, right);
        } else {
            return findMin(nums, left, mid);
        }
    }
    
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
}