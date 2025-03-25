/* You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:

(startx, starty): The bottom-left corner of the rectangle.
(endx, endy): The top-right corner of the rectangle.
Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:

Each of the three resulting sections formed by the cuts contains at least one rectangle.
Every rectangle belongs to exactly one section.
Return true if such cuts can be made; otherwise, return false.

Example 1:

Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]

Output: true

https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/?envType=daily-question&envId=2025-03-25
*/

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xl = new ArrayList<>();
        List<int[]> yl = new ArrayList<>();

        for(int[] r : rectangles) {
            int sx = r[0];
            int ex = r[2];

            int sy = r[1];
            int ey = r[3];

            xl.add(new int[]{sx, 1});
            xl.add(new int[]{ex, 0});

            yl.add(new int[]{sy, 1});
            yl.add(new int[]{ey, 0});
        }

        Collections.sort(xl, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        Collections.sort(yl, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });


        int overlap = 0, count = 0;
        for(int[] arr : xl) {
            // System.out.print(Arrays.toString(arr) + " ");
            if(arr[1] == 1) overlap++;
            else overlap--;

            if(overlap == 0) count++;
        }

        // System.out.println();
        // System.out.println();

        if(count >= 3) return true;
        // System.out.println();

        overlap = count = 0;
         for(int[] arr : yl) {
            // System.out.print(Arrays.toString(arr) + " ");
            if(arr[1] == 1) overlap++;
            else overlap--;

            if(overlap == 0) count++;
        }

        if(count >= 3) return true;
        return false;
    }
}