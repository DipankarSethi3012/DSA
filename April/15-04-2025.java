class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            mp.putIfAbsent(ele, new ArrayList<>());
            mp.get(ele).add(i);
        }
        int res = 0;
        for(Map.Entry<Integer, List<Integer>> e : mp.entrySet()) {
            List<Integer> li = e.getValue();
            for(int i = 0; i < li.size() - 1; i++) {
                for(int j = i + 1; j < li.size(); j++) {
                    int first = li.get(i), second = li.get(j);
                    if((first * second) % k == 0) {
                        // System.out.println("ele: " + e.getKey() + " i: " + i + " j: " + j);
                        res++;
                    }
                }
            }
        }

        return res;
    }
}