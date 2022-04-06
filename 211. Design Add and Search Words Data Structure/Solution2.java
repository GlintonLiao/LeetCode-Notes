class WordDictionary {
    
    int[][] son = new int[(int)1e5][26];
    int[] cnt = new int[(int)1e5];
    int idx = 0;

    public WordDictionary() {
    }
    
    public void addWord(String word) {
        int p = 0;
        for (char c : word.toCharArray()) {
            int u = c - 'a';
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
    
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        return isMatch(chs, 0, 0);
    }
    
    private boolean isMatch(char[] chs, int i, int p) {
        int n = chs.length;
        if (i == n) return cnt[p] != 0;
        if (chs[i] != '.') {
            int u = chs[i] - 'a';
            return son[p][u] != 0 && isMatch(chs, i + 1, son[p][u]);
        } else {
            for (int j = 0; j < 26; j++) {
                if (son[p][j] != 0) {
                    if (isMatch(chs, i + 1, son[p][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
