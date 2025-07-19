class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = obstacles[i];
            int l = 0, r = lis.size();
            while (l < r) {
                int m = (l + r) / 2;
                if (lis.get(m) <= x) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (l == lis.size()) {
                lis.add(x);
            } else {
                lis.set(l, x);
            }
            res[i] = l + 1;
        }
        return res;
    }
}
