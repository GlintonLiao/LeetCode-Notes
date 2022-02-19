class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int idx1 = 0;
        int idx2 = 0;
        
        while (idx2 < arr2.length) {
            while (map.get(arr2[idx2]) != 0) {
                arr1[idx1++] = arr2[idx2];
                map.put(arr2[idx2], map.get(arr2[idx2]) - 1);
            }
            map.remove(arr2[idx2]);
            idx2++;
        }
        
        for (int key : map.keySet()) {
            while (map.get(key) != 0) {
                arr1[idx1++] = key;
                map.put(key, map.get(key) - 1);
            }
        }
        
        return arr1;
    }
}