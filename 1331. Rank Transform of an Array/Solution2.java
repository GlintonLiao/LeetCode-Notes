class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] t = Arrays.copyOf(arr, arr.length);
        Arrays.sort(t);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : t) {
            map.putIfAbsent(n, map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
