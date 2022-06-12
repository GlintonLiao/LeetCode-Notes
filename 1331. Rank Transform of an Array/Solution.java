class Solution {
    List<Integer> after;
    
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) {
            set.add(x);
        }
        
        after = new ArrayList<>(set);
        
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = find(arr[i]);
        }
        return res;
    }
    
    private int find(int x) {
        int l = 0, r = after.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (after.get(mid) >= x)
                r = mid;
            else 
                l = mid + 1;
        }
        return r + 1;
    }
    
}
