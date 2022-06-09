class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        
        int l = 0;
        while (l < n && !isVowel(word.charAt(l))) l++;
        
        int r = n - 1;
        while (r >= 0 && !isVowel(word.charAt(r))) r--;
        
        int res = 0;
        for (int i = l; i <= r - 4; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j <= r; j++) {
                if (isVowel(word.charAt(j))) {
                    set.add(word.charAt(j));
                } else {
                    break;
                }
                if (set.size() == 5) res++;
            }
        }
        
        return res;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c ==  'o' || c == 'u';
    }
}
