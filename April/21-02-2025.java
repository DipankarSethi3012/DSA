class Solution {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        int cd = 0, minDiff = 0, maxDiff = 0;

        for(int ele : diff) {
            cd += ele;
            minDiff = Math.min(cd, minDiff);
            maxDiff = Math.max(cd, maxDiff);

            if(maxDiff - minDiff > upper - lower) return 0;
        }
        int minStart = lower - minDiff;
        int maxStart = upper - maxDiff;
        return Math.max(0, maxStart - minStart + 1);
    }
}