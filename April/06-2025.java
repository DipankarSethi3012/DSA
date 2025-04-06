class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        for(int i=0;i<n;i++){
            hash[i]=i;
        }
        int lastIdx=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(maxi<dp[i]){
                maxi=dp[i];
                lastIdx=i;
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        list.add(nums[lastIdx]);
        while(lastIdx!=hash[lastIdx]){
            lastIdx=hash[lastIdx];
            list.add(nums[lastIdx]);
        }
        return list;
    }
}