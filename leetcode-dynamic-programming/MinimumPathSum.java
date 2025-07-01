class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Use a 1D array to store the current row's results
        int[] dp = new int[n];

        // Initialize the first element (top-left corner)
        dp[0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Process the rest of the grid
        for (int i = 1; i < m; i++) {
            // Handle the first column of each row (we only need the previous row's value)
            dp[0] += grid[i][0];

            // Process the rest of the columns in the current row
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        // The last element of dp contains the minimum path sum
        return dp[n - 1];
    }
}
