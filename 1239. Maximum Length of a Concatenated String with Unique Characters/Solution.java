class Solution {
    int res;
    boolean[] ban;
    
    public int maxLength(List<String> arr) {
        // turn string into number
        int[] nums = new int[arr.size()];
        ban = new boolean[arr.size()];
        int idx = 0;
        for (String s : arr) {
            int n = 0;
            for (char c : s.toCharArray()) {
                int tmp = 1 << (c - 'a');
                if ((n & tmp) != 0) {
                    ban[idx] = true;
                    break;
                }
                n |= 1 << (c - 'a');
            }
            nums[idx++] = n;
        }
        
        dfs(nums, 0, arr, 0, 0);
        return res;
    }
    
    private void dfs(int[] nums, int start, List<String> arr, int curr, int len) {
        res = Math.max(res, len);
        
        for (int i = start; i < nums.length; i++) {
            if ((nums[i] & curr) == 0 && ban[i] == false) {
                dfs(nums, i + 1, arr, curr | nums[i], len + arr.get(i).length());
            }
        }
    }
}