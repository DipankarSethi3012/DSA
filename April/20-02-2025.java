class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        for(int i : answers) {
            if(i == 0) {
                res++;
                continue;
            }
            if(mp.containsKey(i)) {
                mp.put(i, mp.getOrDefault(i, 0) + 1);
                if(mp.get(i) == i + 1) mp.remove(i);
            } else {
                res += i + 1;
                mp.put(i, mp.getOrDefault(i, 0) + 1);
            }
        }

        return res;
    }
}