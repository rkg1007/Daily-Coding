class Solution {
    public int fact(int n) {
        int ans = 1;
        while (n > 0) ans *= n--;
        return ans;
    }
    
    public String getPermutation(int n, int k) {
        String ans = "";
        boolean[] isPicked = new boolean[n + 1];
        int count = 0, totalPicked = 0;
        while (totalPicked != n) {
            int fac = fact(n - totalPicked - 1);
            for (int i = 1; i <= n; i++) {
                if (!isPicked[i]) {
                    if (count + fac >= k) {
                        ans += i;
                        isPicked[i] = true;
                        totalPicked += 1;
                        break;
                    }
                    count += fac;
                }
            }
        }
        
        return ans;
    }
}