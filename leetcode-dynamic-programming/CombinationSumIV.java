class Solution {
    public int combinationSum4(int[] nums, int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;
      
        for (int t = 1; t <= target; t++) {            
            for (int num : nums) {
                if (t - num >= 0) {
                    dp[t] += dp[t - num];
                }
            }
        }

        return (int) dp[target];
    }
}
