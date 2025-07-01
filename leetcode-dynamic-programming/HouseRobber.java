class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0; // حالة خاصة
        if (nums.length == 1) return nums[0]; // حالة منزل واحد فقط

        int prev1 = 0; // المبلغ حتى المنزل السابق
        int prev2 = 0; // المبلغ حتى المنزل قبل السابق

        for (int num : nums) {
            int temp = prev1; // الاحتفاظ بالمبلغ الحالي
            prev1 = Math.max(prev1, prev2 + num); // حساب المبلغ الجديد
            prev2 = temp; // تحديث المبلغ السابق
        }

        return prev1; // أكبر مبلغ يمكن سرقته
    }
}
