class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > k) {
                j -= 1;
            } else if (sum < k) {
                i += 1;
            } else {
                ans += 1;
                i += 1;
                j -= 1;
            }
        }
        return ans;
    }
}