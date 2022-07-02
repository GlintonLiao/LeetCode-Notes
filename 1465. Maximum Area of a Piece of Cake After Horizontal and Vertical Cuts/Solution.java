class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long MOD = (long)1e9 + 7;
        int maxH = 0, maxW = 0;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        maxH = Math.max(maxH, horizontalCuts[0]);
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        
        for (int i = 1; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        maxW = Math.max(maxW, verticalCuts[0]);
        maxW = Math.max(maxW, w - verticalCuts[verticalCuts.length - 1]);
        
        System.out.println(maxH + " " + maxW);
        
        return (int)((long)maxW * maxH % MOD);
    }
}