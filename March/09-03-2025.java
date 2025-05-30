class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans=0;
        int i=0;
        int j=0;
        int prev=-1;
        while(i<colors.length && j<colors.length+k){
            int end=j%colors.length;
            if(colors[end]==prev){
                i=j;
            }
            if(j-i+1==k){
                ans++;
                i++;
            }
            j++;
            prev=colors[end];
            
        }
        return ans;
    }
}