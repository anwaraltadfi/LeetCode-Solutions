class Solution {
    public int maxProfit(int k, int[] prices) {
        // 1) حلات الحواف
        if (k <= 0 || prices == null || prices.length == 0) return 0;

        int n = prices.length;

        // 2) إذا k كبير (كأنه عدد لا محدود من الصفقات)
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        // 3) الحالة العامة: DP بذاكرة O(k)
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // 4) تهيئة: buy[t] = -∞ (قيمة صغيرة جدًا) و sell[t] = 0
        // نستخدم قيمة صغيرة بدل MIN_VALUE لتجنب فيض عند الجمع
        final int NEG_INF = Integer.MIN_VALUE / 4;
        for (int t = 0; t <= k; t++) {
            buy[t] = NEG_INF;
            sell[t] = 0;
        }

        // 5) التحديث عبر الأيام
        for (int price : prices) {
            // t من 1 إلى k
            for (int t = 1; t <= k; t++) {
                // تحديث buy[t]: إما نبقى كما نحن، أو نشتري اليوم اعتمادًا على sell[t-1]
                buy[t] = Math.max(buy[t], sell[t - 1] - price);

                // تحديث sell[t]: إما نبقى كما نحن، أو نبيع اليوم اعتمادًا على buy[t]
                sell[t] = Math.max(sell[t], buy[t] + price);
            }
        }

        // 6) الجواب: أقصى ربح بعد تنفيذ حتى k صفقات (بدون سهم بيدنا)
        return sell[k];
    }
}
