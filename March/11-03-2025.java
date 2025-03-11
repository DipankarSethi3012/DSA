class Solution {
    public int numberOfSubstrings(String s) {
        int start = 0, end = 0, n = s.length(), res = 0;
        int[] freq = new int[3];

        while(end < n) {
            char eChar = s.charAt(end);
            freq[eChar - 'a']++;

           while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                res += (n - end);
                char sChar = s.charAt(start);
                freq[sChar - 'a']--;
                start++;
           }
           end++;
        }
        return res;
    }
}