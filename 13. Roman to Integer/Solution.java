class Solution {
    public int romanToInt(String s) {
        
        int output = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i += 1) {
            int numToAdd = getInt(s.charAt(i));
            if(numToAdd > prev) {
                //prev was added twice, so we need to minus twice
                numToAdd -= 2 * prev;
            }
            output += numToAdd;
            prev = numToAdd;
        }
        
        return output;
    }
    
    private int getInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
