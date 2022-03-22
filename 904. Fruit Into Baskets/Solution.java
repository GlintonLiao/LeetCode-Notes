class Solution {
    public int totalFruit(int[] fruits) {
        // 最多出现两个不同字母的区间的长度最大值
        int res = 0;
        int l = 0, r = 0;
        int[] num = new int[(int)1e5];
        int count = 0;
        int n = fruits.length;
        while (r < n) {
            if (num[fruits[r]]++ == 0) count++;
            r++;
            
            while (count > 2) {
                if (num[fruits[l]]-- == 1) count--;
                l++;
            }
            
            res = Math.max(res, r - l);
        }
        return res;
    }
}
