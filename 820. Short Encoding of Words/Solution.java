class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            int len = w.length();
            for (int i = 1; i < len; i++) {
                set.remove(w.substring(i));
            }
        }
        int res = 0;
        for (String s : set) {
            res += s.length() + 1;
        }
        return res;
    }
}