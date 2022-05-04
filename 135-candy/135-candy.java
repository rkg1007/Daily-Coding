class Solution {
    public void print(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dummyRes = new int[n];
        Arrays.fill(dummyRes, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) dummyRes[i] = dummyRes[i-1] + 1;
        }
        
        int ans = dummyRes[n-1];
        int count = dummyRes[n-1];
        for (int i = n-2; i >= 0; i--) {
            count = (ratings[i] > ratings[i+1]) ? count + 1 : 1;
            ans += Math.max(count, dummyRes[i]);
        }
        
        return ans;
    }
}