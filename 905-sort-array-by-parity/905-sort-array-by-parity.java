class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                res[i++] = num;
            }
        }
        
        for (int num : nums) {
            if (num % 2 == 1) {
                res[i++] = num;
            }
        }
        
        return res;
    }
}