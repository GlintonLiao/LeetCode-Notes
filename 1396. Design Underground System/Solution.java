class UndergroundSystem {
    
    Map<String, TimePair> map;
    Map<Integer, Pair> people;

    public UndergroundSystem() {
        map = new HashMap<>();
        people = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        people.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = people.get(id);
        String name = p.stationName + " " + stationName;
        int time = t - p.t;
        if (map.containsKey(name)) {
            TimePair tp = map.get(name);
            tp.time += time;
            tp.count += 1;
        } else {
            map.put(name, new TimePair(time, 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        TimePair tp = map.get(startStation + " " + endStation);
        // System.out.println(tp.time + " " + tp.count);
        return (double)tp.time / (double)tp.count;
    }
    
    class Pair {
        String stationName;
        int t;
        
        public Pair(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }
    
    class TimePair {
        int time;
        int count;
        
        public TimePair(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */