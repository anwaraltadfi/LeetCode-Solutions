class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int hold1 = Integer.MIN_VALUE; // أفضل ربح ونحن ماسكين السهم بعد أول شراء
        int release1 = 0;              // أفضل ربح بعد بيع الصفقة الأولى
        int hold2 = Integer.MIN_VALUE; // أفضل ربح ونحن ماسكين السهم بعد ثاني شراء
        int release2 = 0;              // أفضل ربح بعد بيع الصفقة الثانية

        for (int price : prices) {
            // انتبه للترتيب: اعتمد الأحدث على الأقدم لنفس اليوم
            release2 = Math.max(release2, hold2 + price);   // بيع الصفقة الثانية
            hold2    = Math.max(hold2, release1 - price);   // شراء الصفقة الثانية
            release1 = Math.max(release1, hold1 + price);   // بيع الصفقة الأولى
            hold1    = Math.max(hold1, -price);             // شراء الصفقة الأولى
        }

        return release2; // أفضل ربح بعد صفقتين كحد أقصى
    }
}
