class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int maxi = 0;
        for(int[] arr : grid) {
            for(int ele : arr) {
                maxi = Math.max(maxi, ele);
            }
        }

        int[] freq = new int[maxi + 1];
        for(int[] arr : grid) {
            for(int ele : arr) {
                freq[ele]++;
            }
        }

        int[] res = new int[2];

       for(int i = 1; i <= maxi; i++) {
            if(freq[i] == 0) {
                res[1] = i;
            } else if(freq[i] == 2) {
                res[0] = i;
            }
       }

       if(res[0] == 0) res[0] = maxi + 1;
       if(res[1] == 0) res[1] = maxi + 1;
        return res;
    }
}