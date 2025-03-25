class Solution {
    public int minCapability(int[] nums, int k) {
        int start = Arrays.stream(nums).min().getAsInt();
        int end = Arrays.stream(nums).max().getAsInt();


        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(f(mid, nums, k)){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean f(int mid, int[] nums, int k) {
        int count = 0, prev = -100;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid && i != prev + 1) {
                prev = i;
                count++;
            } 
        }
        // System.out.println(mid + " " + count);
        return count >= k;
    }
}