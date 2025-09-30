class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        if (s.charAt(0) == '0') return 0;

        
        int prev2 = 1;  
        int prev1 = 1;  

        for (int i = 2; i <= s.length(); i++) {
            int curr = 0;

            char c1 = s.charAt(i - 1);
            if (c1 != '0') {
                curr += prev1;
            }

            char c0 = s.charAt(i - 2);
            int two = (c0 - '0') * 10 + (c1 - '0');
            if (two >= 10 && two <= 26) {
                curr += prev2;
            }

            if (curr == 0) return 0;

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
