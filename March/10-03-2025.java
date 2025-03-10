class Solution {
    public long countOfSubstrings(String word, int k) {
        return f(word, k) - f(word, k + 1);
    }

    private long f(String word, int k) {
        if(k < 0) return 0;
        int n = word.length();
        long res = 0;
        int start = 0, end = 0, cCount = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while(end < n){
            char eChar = word.charAt(end);
            if(isVowel(eChar)){
                mp.put(eChar, mp.getOrDefault(eChar, 0) + 1);
            } else{
                cCount++;
            }

            while(cCount >= k && mp.size() == 5) {
                char sChar = word.charAt(start);
                res += (n - end);
                if(isVowel(sChar)){
                    mp.put(sChar, mp.getOrDefault(sChar, 0) - 1);
                    if(mp.get(sChar) == 0) mp.remove(sChar);
                } else{
                    cCount--;
                }
                start++;
            }

        
            end++;
        }
        return res;
    }

    private boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'e') return true;
        return false;
    }
}