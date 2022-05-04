class Solution {
    public void print(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) res[i] = res[i-1] + 1;
            else {
                int j = i - 1;
                while (j >= 0 && ratings[j] > ratings[j + 1] && res[j] <= res[j + 1]) {
                    // System.out.println(j);
                    res[j] = res[j + 1] + 1;
                    j--;
                }
            }
        }
        // print(res);
        int ans = 0;
        for (int num : res) ans += num;
        return ans;
    }
}