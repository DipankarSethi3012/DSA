class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m= queries.length;
        int start = 0, end = m;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(f(nums, queries, mid)) {
                ans = mid;
                end = mid - 1;
                // System.out.println("True for: " + mid);
            } else {
                // System.out.println("false for : " + mid);
                start = mid + 1;
            }
        }
        
       
        return ans;
    }

    private boolean f(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[nums.length + 1];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        for(int i = 0; i < k; i++) {
            int[] q = queries[i];
            int left = q[0];
            int right = q[1];
            int val = q[2];

            diff[left] -= val;
          if(right + 1 < n)  diff[right + 1] += val;
        }

        int curr = 0;
        for(int i = 0; i < n; i++) {
            curr += diff[i];
            ans[i] += curr;
            if(ans[i] > 0) return false;
        }
        return true;
    }
} 