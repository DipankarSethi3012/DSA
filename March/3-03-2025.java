class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0, right = n - 1, pivotCount = 0;
        
    
        for (int num : nums) {
            if (num < pivot) left++; 
            else if (num == pivot) pivotCount++;
        }
        
        int mid = left; 
        int rightStart = left + pivotCount; 
        int start = 0;
        
        for (int num : nums) {
            if (num < pivot) result[start++] = num; 
            else if (num == pivot) result[mid++] = num;
            else result[rightStart++] = num;
        }

        return result;
    }
}
