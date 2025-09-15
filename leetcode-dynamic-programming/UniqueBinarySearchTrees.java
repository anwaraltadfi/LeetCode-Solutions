class Solution {
    public int numTrees(int n) {
        // dp[k] = عدد أشجار BST الممكنة باستخدام k أعداد متتالية
        int[] dp = new int[n + 1];

        // الأساسات
        dp[0] = 1; // شجرة فارغة
        dp[1] = 1; // عنصر واحد => شجرة واحدة

        // نحسب dp من 2 إلى n
        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            // جرّب كل اختيار للجذر i (بحجم يسار i-1، وحجم يمين nodes-i)
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;
                int right = nodes - root;
                total += dp[left] * dp[right];
            }
            dp[nodes] = total;
        }

        return dp[n];
    }
}
