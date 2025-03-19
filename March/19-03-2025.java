class Solution {
    public int minOperations(int[] nums) {
        int end = 0, n = nums.length, opr = 0;
        
        while(end < n - 2) {
            if(nums[end] == 1) {
                end++;
                continue;
            }

            nums[end] = 1 - nums[end];
            nums[end + 1] = 1 - nums[end + 1];
            nums[end + 2] = 1 - nums[end + 2];
            opr++;
            end++;
        }

        for(int i : nums) {
            if(i != 1) return -1;
        }
        return opr;
    }
}