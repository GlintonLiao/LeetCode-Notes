class MyCalendar {
    
    class Node {
        // ls 和 rs 代表当前节点的左右子节点在 tr 的下标
        // val 表示当前节点有多少数
        // add 为懒标记
        int ls, rs, add, val;
    }
    
    int N = (int)1e9, M = 120010, cnt = 1;
    Node[] tr = new Node[M];
    
    private void update(int u, int lc, int rc, int l, int r, int v) {
        
        if (l <= lc && rc <= r) {
            tr[u].val += (rc - lc + 1) * v;
            tr[u].add += v;
            return;
        }
        
        lazyCreate(u);
        pushdown(u, rc - lc + 1);
        
        int mid = lc + rc >> 1;
        if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
        if (r > mid) update(tr[u].rs, mid + 1, rc, l, r ,v);
        pushup(u);
    }
    
    private int query(int u, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return tr[u].val;
        lazyCreate(u);
        pushdown(u, rc - lc + 1);
        
        int mid = lc + rc >> 1, res = 0;
        if (l <= mid) res = query(tr[u].ls, lc, mid, l, r);
        if (r > mid) res += query(tr[u].rs, mid + 1, rc, l, r);
        return res;
    }
    
    private void lazyCreate(int u) {
        if (tr[u] == null) tr[u] = new Node();
        if (tr[u].ls == 0) {
            tr[u].ls = ++cnt;
            tr[tr[u].ls] = new Node();
        }
        if (tr[u].rs == 0) {
            tr[u].rs = ++cnt;
            tr[tr[u].rs] = new Node();
        }
    }
    
    private void pushdown(int u, int len) {
        tr[tr[u].ls].add += tr[u].add;
        tr[tr[u].rs].add += tr[u].add;
        tr[tr[u].ls].val += (len - len / 2) * tr[u].add;
        tr[tr[u].rs].val += len / 2 * tr[u].add;
        tr[u].add = 0;
    }
    
    private void pushup(int u) {
        tr[u].val = tr[tr[u].ls].val + tr[tr[u].rs].val;
    }

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if (query(1, 1, N + 1, start + 1, end) > 0) return false;
        update(1, 1, N + 1, start + 1, end, 1);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */