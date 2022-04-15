class Solution {
    List<String> res = new LinkedList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        StringBuilder sb = new StringBuilder("0000000000");
        dfs(sb, 0, turnedOn);
        return res;
    }
    
    private void dfs(StringBuilder sb, int start, int k) {
        if (k == 0) {
            int hour = Integer.valueOf(sb.substring(0, 4), 2);
            int min = Integer.valueOf(sb.substring(4, 10), 2);
            if (hour > 11 || min > 59) return;
            StringBuilder tmp = new StringBuilder();
            tmp.append(hour);
            tmp.append(":");
            tmp.append(min < 10 ? "0" + min : min);
            res.add(tmp.toString());
            return;
        }
        
        for (int i = start; i < 10; i++) {
            if (sb.charAt(i) != 1) {
                sb.setCharAt(i, '1');
                dfs(sb, i + 1, k - 1);
                sb.setCharAt(i, '0');
            }
        }
    }
}