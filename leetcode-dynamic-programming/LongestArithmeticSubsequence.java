import java.util.*;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        // لكل عنصر نحتفظ بـ HashMap (الفرق -> الطول)
        Map<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int length = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, length);
                max = Math.max(max, length);
            }
        }
        
        return max;
    }
}
