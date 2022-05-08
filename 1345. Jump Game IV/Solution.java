class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        dist[0] = 0;
        
        while (!q.isEmpty()) {
            int t = q.poll();
            int step = dist[t];
            if (t == n - 1) return step;
            if (t + 1 < n && dist[t + 1] == Integer.MAX_VALUE) {
                q.offer(t + 1);
                dist[t + 1] = step + 1;
            }
            if (t - 1 >= 0 && dist[t - 1] == Integer.MAX_VALUE) {
                q.offer(t - 1);
                dist[t - 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
            for (int ne : list) {
                if (dist[ne] == Integer.MAX_VALUE) {
                    q.offer(ne);
                    dist[ne] = step + 1;
                }
            }
            map.remove(arr[t]);
        }
        return -1;
    }
}