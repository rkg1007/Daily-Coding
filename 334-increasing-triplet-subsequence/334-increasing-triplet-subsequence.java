class Solution {
    public void print(int[] arr) {
        for(int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) left[i] = nums[i];
            else left[i] = Math.min(left[i-1], nums[i]);
        }
        print(left);
        
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) right[i] = nums[i];
            else right[i] = Math.max(right[i+1], nums[i]);
        }
        print(right);
        
        for (int i = 1; i < n - 1; i++) {
            if (left[i-1] < nums[i] && right[i+1] > nums[i]) {
                return true;
            }
        }
        
        return false;
    }
}