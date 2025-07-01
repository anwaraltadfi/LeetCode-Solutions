class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; // الحالات الأساسية
        
        int[] dp = new int[n + 1]; // إنشاء مصفوفة لتخزين النتائج
        dp[1] = 1; // طريقة واحدة للوصول إلى الدرجة الأولى
        dp[2] = 2; // طريقتان للوصول إلى الدرجة الثانية

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // العلاقة التكرارية
        }

        return dp[n]; // النتيجة النهائية
    }
}



