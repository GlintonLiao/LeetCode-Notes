class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        Set<Integer> res = new HashSet<>(), prev = new HashSet<>();
        for (int num : nums) {
            Set<Integer> cur = new HashSet<>();
            cur.add(num);
            for (int old : prev) cur.add(old | num);
            res.addAll(cur);
            prev = cur;
        }
        return res.size();
    }
}
