class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[j] = (obstacleGrid[0][j] == 1) ? 0 : dp[j - 1];
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            // The first cell in each row
            dp[0] = (obstacleGrid[i][0] == 1) ? 0 : dp[0];
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
