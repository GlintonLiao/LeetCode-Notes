public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i -= 1) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] output = new int[n + 1];
        output[0] = 1;
        
        return output;
    }
}
