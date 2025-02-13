class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i : nums) {
            pq.offer((long)i);
        }
        int count = 0;
        while(pq.size() > 1 && pq.peek() < k) {
            long first = pq.poll();
            long second = pq.poll();

            long ele = Math.min(first, second) * 2 + Math.max(first, second);
            pq.offer(ele);
            count++;
            // System.out.println(pq);
        }
        return count;
    }
}