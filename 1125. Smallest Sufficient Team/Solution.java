class Solution {
    List<Integer> candidate = new ArrayList<>();
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>(); 
        int idx = 0;
        for (String s : req_skills) map.put(s, idx++); // skills are represented by 0, 1, 2....
        
        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                int skill = map.get(p);
                pe[i] += 1 << skill;
            }
        } // state compression
        
        search(0, pe, new ArrayList<Integer>(), idx);  
        
        
        int[] res = new int[candidate.size()];
        for (int i = 0; i < candidate.size(); i++) res[i] = candidate.get(i);
        return res;
    }
    
    public void search(int cur, int[] pe, List<Integer> onesol, int n) { 
        if (cur == (1 << n) - 1) {  // when all bits are 1, all skills are coverred
            if (candidate.size() == 0 || onesol.size() < candidate.size()) {
                candidate = new ArrayList<>(onesol);
            }
            return;
        }
        
        if (candidate.size() != 0 && onesol.size() >= candidate.size()) return;    // pruning
        
        int zeroBit = 0;
        while (((cur >> zeroBit) & 1) == 1) zeroBit++;
        
        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
            if (((per >> zeroBit) & 1) == 1) {
                onesol.add(i);
                search(cur | per, pe, onesol, n);
                onesol.remove(onesol.size() - 1);
            }
        } 
    }
}
