class TopVotedCandidate {

    private Map<Integer, Integer> map = new HashMap<>(); // time and leading candidate
    private int[] times;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int[] count = new int[persons.length + 1]; // count[i]: count of votes for persons[i].
        
        for (int i = 0, winner = -1; i < times.length; i++) {
            count[persons[i]]++; // at times[i], persons[i] got a vote.
            
            // is persons[i] leading? update winner.
            if (map.isEmpty() || count[winner] <= count[persons[i]]) { 
                winner = persons[i]; 
            } 
            map.put(times[i], winner); // update time and winner.
        }
    }
    
    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (times[mid] <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        // search for the time slot.
        return map.get(times[l]); // fetch the corresponding information.
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
