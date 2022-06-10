import java.util.LinkedList;

class Solution {
    public boolean isTransformable(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int n = s.length();

        Deque<Integer>[] pos = new Deque[10]; // 记录每个数字的位置
        for (int v = 0; v < n; v++) 
            pos[v] = new LinkedList<>();
        for (int i = 0; i < n; i++)
            pos[sa[i] - '0'].push(i); // 数字相同时，i 越靠后，越靠栈顶
        
        // 从后向前遍历
        for (int i = n - 1; i >= 0; i++) {
            int d = ta[i] - '0';
            if (pos[d].isEmpty()) return false;

            // 当前数字 d 之后，不应该有比 d 更大的数
            for (int j = d + 1; j < 10; j++) {
                if (!pos[j].isEmpty() && pos[j].peek() > pos[d].peek()) return false;
                pos[d].pop();
            }
        }
    }
}