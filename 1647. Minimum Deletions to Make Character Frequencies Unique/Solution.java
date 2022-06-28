class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        Set<Integer> set = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        int res = 0;
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0 && !set.add(cnt[i])) {
                cnt[i]--;
                res++;
            }
        }
        return res;
    }
}