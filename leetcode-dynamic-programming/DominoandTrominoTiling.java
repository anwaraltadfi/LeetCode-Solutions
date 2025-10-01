class Solution {
    public int numTilings(int N) {
        int MOD = 1000000007;
        long[] dp = new long[N + 1];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 1;
        if (N > 1) dp[2] = 2;
        
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        
        return (int) dp[N];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 3;
        int ways1 = solution.numTilings(n1);
        System.out.println("Ways for N = " + n1 + ": " + ways1); // Output: 5

        // Example 2
        int n2 = 1;
        int ways2 = solution.numTilings(n2);
        System.out.println("Ways for N = " + n2 + ": " + ways2); // Output: 1
    }
}
