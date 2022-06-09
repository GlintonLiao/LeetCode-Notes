class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<List<String>> bucket = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            bucket.add(new LinkedList<>());
        }
        
        for (String w : words) {
            bucket.get(w.charAt(0) - 'a').add(w);
        }
        
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            List<String> list = bucket.get(s.charAt(i) - 'a');
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                String temp = list.get(j);
                if (temp.length() == 1) {
                    res++;
                } else {
                    temp = temp.substring(1, temp.length());
                    bucket.get(temp.charAt(0) - 'a').add(temp); 
                }
                list.remove(j);
            }
        }
        return res;
    }
}