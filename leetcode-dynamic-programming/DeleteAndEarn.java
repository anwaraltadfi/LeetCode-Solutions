class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0; // ✅ معالجة الحالة الخاصة إذا كانت المصفوفة فارغة

        // 🔄 إيجاد أكبر عدد في المصفوفة لتحديد حجم المصفوفة المساعدة
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // 📊 إنشاء مصفوفة لحساب النقاط لكل عدد
        int[] points = new int[maxNum + 1];
        for (int num : nums) {
            points[num] += num; // إضافة مجموع النقاط لكل عدد
        }

        // 💡 حل المشكلة باستخدام Dynamic Programming مثل House Robber
        int prev1 = 0, prev2 = 0; // تخزين القيم السابقة
        for (int i = 0; i <= maxNum; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + points[i]); // اختيار أفضل قيمة بين أخذ العدد أو تخطيه
            prev2 = temp;
        }

        return prev1; // ✅ إرجاع أكبر عدد ممكن من النقاط
    }
}
