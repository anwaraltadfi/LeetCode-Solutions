class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer[] memo = new Integer[n];          
        return solve(0, days, costs, memo);       
    }

    private int solve(int i, int[] days, int[] costs, Integer[] memo) {
        if (i >= days.length) return 0;           
        if (memo[i] != null) return memo[i];      

        int cost1 = costs[0] + solve(i + 1, days, costs, memo);

        int j = i;
        int cover7 = days[i] + 7;                 
        while (j < days.length && days[j] < cover7) j++;
        int cost7 = costs[1] + solve(j, days, costs, memo);

        int k = i;
        int cover30 = days[i] + 30;               
        while (k < days.length && days[k] < cover30) k++;
        int cost30 = costs[2] + solve(k, days, costs, memo);

        int best = Math.min(cost1, Math.min(cost7, cost30));
        memo[i] = best;                           
        return best;
    }
}
