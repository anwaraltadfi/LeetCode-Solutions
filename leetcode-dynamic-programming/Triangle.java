class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1]; // dp array for storing minimum path sums

        // Bottom-up dynamic programming
        for(int row = n - 1; row >= 0; row--) {
            for(int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0]; // The result will be at the top of the triangle (dp[0])
    }
}
