class Solution {
    public int minFlipsMonoIncr(String S) {
        if(S == null || S.length() <= 0) return 0;

        char[] chars = S.toCharArray();
        int flipCount = 0;
        int onesCount = 0;

        for(int i = 0; i < chars.length; i++){
            
            if (chars[i] == '0') {
                if (onesCount == 0) continue;
                else flipCount++;
            } else {
                onesCount++;
            }
            
            if (flipCount > onesCount) {
                flipCount = onesCount;
            }
        }
        return flipCount;
    }
}