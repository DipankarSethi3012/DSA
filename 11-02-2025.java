class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        // System.out.println(part.length());
        char last = part.charAt(part.length() - 1);
        // System.out.println(s.substring(0, part.length()));
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // if(ch == part.charAt(0)) {
            //     int size = Math.min(s.length(), i + part.length());
            //     System.out.println("index: " + i + "  " + s.substring(i, size));
            //     System.out.println(s.substring(i, size).length());
            //     String temp = s.substring(i, size);
            //     if(temp.equals(part)) {
            //         System.out.println("heelo");
            //     }
            // }
            if(ch == last) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                int j = part.length() - 2;
                while(!st.isEmpty() && j >= 0 && st.peek() == part.charAt(j)) {
                    char top = st.pop();
                    sb.append(top);
                    j--;
                }
                String temp = sb.reverse().toString();
                // System.out.println(temp);
                if(j < 0 || temp.equals(part)) continue;
                for(int x = 0; x < sb.length(); x++) {
                    st.add(sb.charAt(x));
                }
            } else{
                st.add(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}