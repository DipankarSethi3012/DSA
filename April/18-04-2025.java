class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        StringBuilder res = new StringBuilder("1");
        for(int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            char prev = res.charAt(0);
            int count = 1;

            for(int j = 1; j < res.length(); j++) {
                if(prev == res.charAt(j)) {
                    count++;
                } else{
                    temp.append(count).append(prev);
                    prev = res.charAt(j);
                    count = 1;
                }
            }

            temp.append(count).append(prev);
            res = temp;
        }

        return res.toString();
        
    }
}