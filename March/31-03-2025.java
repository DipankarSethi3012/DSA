class Solution {
    public long putMarbles(int[] arr, int k) {
        int n = arr.length;
        if(n == k) return 0l;
        List<Long> li = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            long sum = arr[i] + arr[i + 1];
            li.add(sum);
        }

        Collections.sort(li);
        // System.out.println(li);
        long mini = 0, maxi = 0;
        int x = li.size();
        for(int i = 0; i < x; i++) {
            if(k == 1) break;
            mini += (li.get(i));
            maxi += li.get(x - i - 1);
            k--;
        }

        return maxi - mini;

    }
}