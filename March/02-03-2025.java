class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length, m = nums2.length;
        List<int[]> li = new ArrayList<>();
        
        int i = 0, j = 0;

        while(i < n && j < m) {
            if(nums1[i][0] == nums2[j][0]) {
                li.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } 
            else if(nums1[i][0] > nums2[j][0]) {
                li.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            } else{
                li.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            }
        }

        while(i < n) {
            li.add(nums1[i]);
            i++;
        }

        while(j < m) {
            li.add(nums2[j]);
            j++;
        }
        
        int[][] res = new int[li.size()][2];
        for(int x = 0; x < li.size(); x++) {
            res[x] = li.get(x);
        }

        return res;
    }   
}