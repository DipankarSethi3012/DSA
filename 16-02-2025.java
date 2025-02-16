import java.util.Arrays;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = n * 2 - 1;
        int[] arr = new int[size];
        boolean[] used = new boolean[n + 1];

        backtrack(arr, used, 0, n);
        return arr;
    }

    private boolean backtrack(int[] arr, boolean[] used, int idx, int n) {
        if (idx >= arr.length) return true;

        
        if (arr[idx] != 0) {
            return backtrack(arr, used, idx + 1, n);
        }

        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;

            int nextIdx = (i == 1) ? idx : idx + i;

            if (nextIdx >= arr.length || arr[nextIdx] != 0) continue;

            used[i] = true;
            arr[idx] = i;
            if (i != 1) arr[nextIdx] = i; 

            if (backtrack(arr, used, idx + 1, n)) return true;

            used[i] = false;
            arr[idx] = 0;
            if (i != 1) arr[nextIdx] = 0;
        }

        return false;
    }
}
// Time Complexity: O(n!)
// Space Complexity: O(n)