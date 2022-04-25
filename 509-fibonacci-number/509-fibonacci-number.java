class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int curr = 1, last = 0;
        for (int i = 2; i <= n; i++) {
            curr = curr + last;
            last = curr - last;
        }
        return curr;
    }
}