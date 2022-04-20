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
        
        boolean[] isBannedArr = calculateDuplicate(pe, req_skills.length);
        search(0, pe, new ArrayList<Integer>(), idx, isBannedArr);  
        
        
        int[] res = new int[candidate.size()];
        for (int i = 0; i < candidate.size(); i++) res[i] = candidate.get(i);
        return res;
    }
    
    public void search(int cur, int[] pe, List<Integer> onesol, int n, boolean[] isBannedArr) { 
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
            if (isBannedArr[i]) continue;
            int per = pe[i];
            if (((per >> zeroBit) & 1) == 1) {
                onesol.add(i); // when a person can cover a zero bit in the current number, we can add him
                search(cur | per, pe, onesol, n, isBannedArr);
                onesol.remove(onesol.size() - 1);  // search in a backtracking way
            }
        } 
    }
    
    private boolean[] calculateDuplicate(int[] peopleBinary, int len) {
        boolean[] isDuplicateArr = new boolean[peopleBinary.length];
        //compare people[i] and people[j], if skill_i > skill_j means people_i have at least one skill people_j doesn't have, and vice versa
        for (int i = 0; i < peopleBinary.length; i++){
            for (int j = i + 1; j < peopleBinary.length; j++){
                if (peopleBinary[i] == peopleBinary[j]) {
                    isDuplicateArr[j] = true;
                } else if (peopleBinary[i] > peopleBinary[j] && isPeopleContainsAll(peopleBinary[i],peopleBinary[j],len)) {
                    isDuplicateArr[j] = true;
                } else if (peopleBinary[j] > peopleBinary[i] && isPeopleContainsAll(peopleBinary[j],peopleBinary[i],len)) {
                    isDuplicateArr[i] = true;
                }
            }
        }
        return isDuplicateArr;
    }
    
    private boolean isPeopleContainsAll(int skill1, int skill2, int len) {
        int mask = 1;
        for (int i = 0; i < len; i++){
            if ((skill1 & mask) == 0 && (skill2 & mask) > 0) return false;
            mask <<= 1;
        }
        return true;
    }
}
