class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        
        // for odd num, it can only *2 one time
        for (int n : nums) {
            if (n % 2 == 0) {
                set.add(n);
            } else {
                set.add(n * 2);
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        while (true) {
            int max = set.last();
            result = Math.min(result, max - set.first());
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                break;
            }
        }
        
        return result;
    }
}
