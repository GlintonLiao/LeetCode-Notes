class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int min = Math.min(arr1.length, arr2.length);
        
        for (int i = 0; i < min; i++) {
            int n1 = Integer.parseInt(arr1[i]);
            int n2 = Integer.parseInt(arr2[i]);
            if (n1 > n2) return 1;
            if (n1 < n2) return -1;
        }
        
        int idx = min;
        
        while (idx < arr1.length) {
            if (Integer.parseInt(arr1[idx++]) != 0) return 1;
        }
        
        while (idx < arr2.length) {
            if (Integer.parseInt(arr2[idx++]) != 0) return -1;
        }
        
        return 0;
    }
}