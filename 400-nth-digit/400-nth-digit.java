class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long totalDigits = 9;
        long min = 1, max = 10;
        while (n > totalDigits) {
            min = max;
            max *= 10;
            len += 1;
            n -= totalDigits;
            totalDigits = (max - min) * len;
        }
        long num, digit;
        int ans = 0;
        num = min + (n - 1) / len;
        digit = (n - 1) % len;
        for (int i = 0; i < len - digit; i++) {
            ans = (int)(num % 10);
            num /= 10;
        }
        return ans;
    }
}