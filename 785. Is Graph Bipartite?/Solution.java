class Solution {
    int n;
    int[] color;
    
    public boolean isBipartite(int[][] graph) {
        boolean res = true;
        n = graph.length;
        color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, 0)) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
    
    private boolean dfs(int[][] graph, int u, int c) {
        color[u] = c;
        for (int i : graph[u]) {
            if (color[i] == -1) {
                if (!dfs(graph, i, c == 0 ? 1 : 0)) return false;
            } else if (color[i] == c) {
                return false;
            }
        }
        return true;
    }
}