class Solution {
    public int minimumOperations(int[] nums) {
        int left = 1, n = nums.length, count = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int size = n;
        if(mp.size() == size) return 0;
        while(left < n - 1) {
            int first = nums[left - 1];
            int second = nums[left];
            int third = nums[left + 1];

            mp.put(first, mp.getOrDefault(first, 0) - 1);
            if(mp.get(first) == 0) mp.remove(first);
            mp.put(second, mp.getOrDefault(second, 0) - 1);
            if(mp.get(second) == 0) mp.remove(second);
            mp.put(third, mp.getOrDefault(third, 0) - 1);
            if(mp.get(third) == 0) mp.remove(third);

            size -= 3;
            count++;
            if(mp.size() == size) return count;
            left += 3;
        }

        return count + 1;

    }
}