class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        for(int i = n - 1; i >= 0; i--) {
            long pick = questions[i][0];

            int nextIdx = i + questions[i][1] + 1;

            if(nextIdx < n) {
                pick += dp[nextIdx];
            }

            long notPick = dp[i + 1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[0];
    }
}