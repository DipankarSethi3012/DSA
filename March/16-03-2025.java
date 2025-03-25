class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start = 1, end = (long)1e14;

        while(start <= end) {
            long mid = start + (end - start) / 2;
            if(f(mid, ranks, cars)) {
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean f(long time, int[] ranks, int cars) {
        // System.out.println("time: " + time);
        long count = 0;
        for(int rank : ranks) {
            count += (long)Math.sqrt((time / rank));
            if(count >= cars) return true;
        }

        return count >= cars;
    }
}