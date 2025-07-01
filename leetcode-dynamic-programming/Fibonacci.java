class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n; // F(0) = 0, F(1) = 1
        }

        int prev1 = 0; // F(n-2)
        int prev2 = 1; // F(n-1)
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2; // F(n) = F(n-1) + F(n-2)
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }
}





