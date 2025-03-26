class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int[] arr = new int[n * m];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
       

        int mid = (arr.length / 2);
        int opr = f(mid, arr, x);

        return opr; 
    }

    private int f(int mid, int[] arr, int x) {
        int opr = 0;

         for(int i = 0; i < mid; i++) {
            int diff = arr[mid] - arr[i];
            if(diff % x != 0) return -1;
            opr += (diff / x);
        }

        for(int i = mid + 1; i < arr.length; i++) {
            int diff = arr[i] - arr[mid];
            if(diff % x != 0) return -1;
            opr += (diff / x);
        }

        return opr;
    }
}