class Solution {
    public int tribonacci(int n) {
        if (n <= 1) return n;
        int curr = 1, last = 1, lastSecond = 0;
        for (int i = 3; i <= n; i++) {
            curr = curr + last + lastSecond;
            last = curr - last - lastSecond;
            lastSecond = curr - last - lastSecond;
        }
        return curr;
    }
}