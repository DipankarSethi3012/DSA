class Solution {
    public int countSymmetricIntegers(int low, int high) {
        
        int count = 0;

        for(int i = low; i <= high; i++) {

            if(f(i)) count++;
        }

        return count;
    }

    private boolean f(int num) {
        String s = Integer.toString(num);
        if(s.length() % 2 != 0) return false;

        int n = s.length() / 2;
        int i = 0, sum = 0;
        while(i < n) {
            char ch = s.charAt(i);
            sum += (ch - '0');
            i++;
        }

        while(i < s.length()) {
            char ch = s.charAt(i);
            sum -= (ch - '0');
            i++;
        }
        return sum == 0;
    }
}