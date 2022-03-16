class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String c : d)
            if ((c.length() > res.length() || 
                 c.length() == res.length() && 
                 c.compareTo(res) < 0) &&
                 isSubseq(c, s)) 
                res = c;
        return res;
    }
    
    public boolean isSubseq(String a, String b){
        int i = 0, j = 0;
        int aLen = a.length(), bLen = b.length();
        while (j < bLen) {
            if (i < aLen && a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == aLen;
    }
}