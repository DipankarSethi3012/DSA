class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder res = new StringBuilder();
        int[] arr = new int[n + 1];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            arr[idx++] = i + 1;
            if(i == n || pattern.charAt(i) == 'I') {
                while(idx > 0) {
                    res.append(arr[--idx]);
                }
            }
        }
        return res.toString();
    }
}