class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 1; i < n; i++) { // نمر على كل صف من الصف الثاني
            for (int j = 0; j < n; j++) { // نمر على كل عمود
                int minAbove = matrix[i-1][j]; // القيمة فوق مباشرة
                
                if (j > 0) {
                    minAbove = Math.min(minAbove, matrix[i-1][j-1]); // القيمة من اليسار
                }
                if (j < n-1) {
                    minAbove = Math.min(minAbove, matrix[i-1][j+1]); // القيمة من اليمين
                }
                
                matrix[i][j] += minAbove; // نجمع أقل قيمة مع الحالية
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, matrix[n-1][j]); // نبحث عن أقل قيمة بآخر صف
        }
        
        return result;
    }
}
