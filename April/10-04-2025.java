class Solution {
    private static final int MAX_DIGITS = 17;
    private long[][] dp;

    public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        long suffixVal = Long.parseLong(suffix);
        String finishStr = Long.toString(finish);
        String startStr = Long.toString(start - 1);
        
        int finishDigits = finishStr.length();
        int startDigits = startStr.length();

        long uptoFinish = (finish >= suffixVal) ? solveUpTo(finishStr, finishDigits, limit, suffix) : 0;
        long uptoStart = (suffixVal < start) ? solveUpTo(startStr, startDigits, limit, suffix) : 0;

        return uptoFinish - uptoStart;
    }

    private long solveUpTo(String numStr, int numDigits, int limit, String suffix) {
        dp = new long[MAX_DIGITS][2];

        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }

        long res = countValidNumbers(numStr, 0, numDigits, true, limit, suffix);

        if(checkSub(numStr, numDigits, suffix, limit)) {
            res--;
        }
        return res;
    }

    private long countValidNumbers(String numStr, int idx, int maxDigits, boolean isTight, int limit, String suffix) {
        if(idx == maxDigits) return 1;

        if(dp[idx][isTight ? 1 : 0] != -1) return dp[idx][isTight? 1 : 0];
        int low, high;
        int suffixLen = suffix.length();

        if(idx >= maxDigits - suffixLen) {
            int suffixIdx = idx - (maxDigits - suffixLen);
            low = high = suffix.charAt(suffixIdx) - '0';
        } else{
            high = isTight ? Math.min(limit, numStr.charAt(idx) - '0') : limit;
            low = 0;
        }

        long total = 0;
        for(int digit = low; digit <= high; ++digit) {
            boolean newTight = isTight && (digit == numStr.charAt(idx) - '0');
            total += countValidNumbers(numStr, idx + 1, maxDigits, newTight, limit, suffix);
        }

        return dp[idx][isTight? 1 : 0] = total;
    
    }
    private boolean checkSub(String numStr, int numDigits, String suffix, int limit) {
        if(numDigits < suffix.length()) return false;

        String suffixOfNum = numStr.substring(numDigits - suffix.length());
        boolean subtract = Long.parseLong(suffixOfNum) < Long.parseLong(suffix);

        if(subtract) {
            for(int i = 0; i < numDigits - suffix.length(); ++i) {
                if((numStr.charAt(i) - '0') > limit) {
                    subtract = false;
                    break;
                }
            } 
        }

        return subtract;
    }
}