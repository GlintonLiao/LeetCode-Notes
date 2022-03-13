class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        
        while (n-- > 1) {
            long num = set.pollFirst();
            set.add(num * 2);
            set.add(num * 3);
            set.add(num * 5);
        }
        
        return set.first().intValue();
    }
}
