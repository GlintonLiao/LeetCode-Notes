class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) {
            return startValue - target;
        } else {
            return (target & 1) == 0 ? brokenCalc(startValue, target >> 1) + 1 : brokenCalc(startValue, target + 1) + 1;
        }
    }
}
