/* 
 416. Partiton equal subset sum
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int num : nums) {
            sum += num;
        }

       
        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

     
        for (int index = n - 1; index >= 0; index--) {
            for (int t = 0; t <= target; t++) {
                boolean pick = false;
                if (t - nums[index] >= 0) {
                    pick = dp[index + 1][t - nums[index]];
                }

                boolean notPick = dp[index + 1][t];

                dp[index][t] = pick || notPick;
            }
        }

        return dp[0][target];
    }
}
