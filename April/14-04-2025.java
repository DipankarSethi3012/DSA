class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0;
        int start = 0, end = 0, n = nums.length, p = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while(end < n) {
            mp.put(nums[end], mp.getOrDefault(nums[end], 0) + 1);
            p += mp.get(nums[end]) - 1;

            while(p >= k) {
                res += (n - end);
                mp.put(nums[start], mp.getOrDefault(nums[start], 0) - 1);

                if(mp.get(nums[start]) == 0) {
                    mp.remove(nums[start]);
                }
                else{
                    p -= mp.get(nums[start]);
                }
                start++;
            }

            end++;
        }
        return res;
    }
}