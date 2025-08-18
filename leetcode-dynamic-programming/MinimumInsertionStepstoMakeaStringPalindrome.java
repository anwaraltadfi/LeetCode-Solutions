class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            // dp[i][i] = 0 تلقائياً (حرف واحد باليندروم)
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // لو الحرفين متساويين، نأخذ كلفة الداخل
                    dp[i][j] = (j - i == 1) ? 0 : dp[i + 1][j - 1];
                } else {
                    // مختلفين: نضيف إدخال واحد ونأخذ الأقل بين الحالتين
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
