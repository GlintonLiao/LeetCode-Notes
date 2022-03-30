class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // 找到每个点在哪个角度上
        List<Double> angles = new ArrayList<>();
        int cnt = 0;
        
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                cnt++;
                continue;
            }
            angles.add(Math.atan2(dx, dy) * (180 / Math.PI));
        }
        
        // 给每一个角度都加上 360 度，使得角度是「成环」的
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360);
        int res = cnt;
        
        // 滑动窗口
        int l = 0, r = 0;
        int n = tmp.size();
        while (r < n) {
            while (tmp.get(r) - tmp.get(l) > angle) l++;
            res = Math.max(res, cnt + r - l + 1);
            r++;
        }
        
        return res;
    }
}
