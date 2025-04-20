class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        
        return f(nums, upper + 1) - f(nums, lower);
    }

    private long f(int[] nums, int target) {
        long res = 0;
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];

            if(sum < target) {
                 res += (end - start);
                start++;
            } else {
               
                   end--;
            }
        }
        return res;
    }
}