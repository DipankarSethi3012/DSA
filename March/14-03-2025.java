class Solution {
    public int maximumCandies(int[] candies, long k) {
        int end = 0;
        for(int i : candies) {
            end = Math.max(end, i);
        }

        // if(k > end) return 0;
        int start = 1, res = 0;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(binarySearch(mid, candies, k)) {
                res = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return res;
    }

    private boolean binarySearch(int mid, int[] nums, long k) {
        
        long count = 0;
        for(int i : nums) {
            count += (i / mid);
        }
        return count >= k;
    }
}