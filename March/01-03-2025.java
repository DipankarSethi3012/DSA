class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i- 1]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }

        while(idx < n) {
            nums[idx++] = 0;
        }
        

        return nums;
    }
}