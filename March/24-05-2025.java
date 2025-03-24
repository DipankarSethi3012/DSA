class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
  
        int count = 0, n = meetings.length;
        int end = meetings[0][1];
        if(meetings[0][0] != 1) {
            count += meetings[0][0] - 1;
        }
        for(int i = 1; i < meetings.length; i++) {
            if(meetings[i][0] <= end + 1) {
                end = Math.max(meetings[i][1], end);
            } else{
                count += meetings[i][0] - end - 1;
                end = meetings[i][1];
            }
        }

        if(end < days) {
            count = count +  (days - end);
        }

        return count;
    }
}