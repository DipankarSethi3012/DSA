class Solution {
    public int punishmentNumber(int n) {
        int sum = 1;
        for(int i = 9; i <= n; i++) {
            int mul = i * i, x = mul;
            String s = Integer.toString(mul);
            // if(i != 36 && i != 9 && i != 10) continue;
            boolean[] arr = new boolean[1];
            f(0, s, i, arr, "");
            if(arr[0]) sum += mul;
        }
        return sum;
    }

    private void f(int index, String s,int target, boolean[] arr, String temp) {
      if(index >= s.length()) {
            
            String[] str = temp.split(" ");
        //    if(temp.trim().equals(s)) return;
            // System.out.println(Arrays.toString(str));
            int sum = 0;
            for(String x : str) {
                if(x.equals(s)) return;
                sum += (Integer.parseInt(x));
            }
            if(sum == target) {
                // System.out.println(Arrays.toString(str) +" target: " + target);
                // System.out.println(temp.trim() + "  " + s);
                arr[0] = true;
            }
            return;
       }

       f(index + 1, s, target, arr, temp + s.charAt(index));
       f(index + 1, s, target, arr, temp + s.charAt(index) + " ");
        
    }
}