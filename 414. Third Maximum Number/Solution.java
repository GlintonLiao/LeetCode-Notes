class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) set.add(n);
        
        int res = set.last();
        for (int i = 0; i < 3; i++) {
            if (set.isEmpty()) break; 
            if (i == 2) res = set.pollLast();
            set.pollLast();
        }
        return res;
    }
}