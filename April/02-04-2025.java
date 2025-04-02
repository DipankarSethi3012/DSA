/* 
    *  LeetCode 2552. Maximum Triplet Value
    *  https://leetcode.com/problems/maximum-triplet-value/
    *
    *  Given an integer array nums, return the maximum value of (nums[i] - nums[j]) * nums[k]
    *  where 0 <= i < j < k < nums.length.
    *
    *  Example:
    *  Input: nums = [1,2,3]
    *  Output: 2
    * Explanation: The maximum value is (3 - 1) * 2 = 4.
    *   *  Constraints:
    *  3 <= nums.length <= 10^5
    * 1 <= nums[i] <= 10^5
    */


class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }
}