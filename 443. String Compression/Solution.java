class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        int idx = 0;
        
        while (i < chars.length) {
            while (j < chars.length && chars[j] == chars[i]) j++;
            if (j - i == 1) {
                chars[idx++] = chars[i];
                i++;
            } else {
                chars[idx++] = chars[i];
                String temp = String.valueOf(j - i);
                for (char c : temp.toCharArray()) {
                    chars[idx++] = c;
                }
                i = j;
            }
        }
        
        return idx;
    }
}