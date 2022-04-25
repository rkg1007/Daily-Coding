class UndergroundSystem {
    HashMap<Integer, HashMap<String, Integer>> persons;
    HashMap<String, HashMap<String, HashMap<String, Integer>>> paths;

    public UndergroundSystem() {
        this.persons = new HashMap<>();
        this.paths = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        this.persons.put(id, new HashMap<String, Integer>());
        this.persons.get(id).put(stationName, t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String inStationName;
        int inTime;
        for (Map.Entry<String, Integer> entry : this.persons.get(id).entrySet()) {
            inStationName = entry.getKey();
            inTime = entry.getValue();
            
            if (!this.paths.containsKey(inStationName)) {
                this.paths.put(inStationName, new HashMap<String, HashMap<String, Integer>>());
            }
            if (!this.paths.get(inStationName).containsKey(stationName)) {
                this.paths.get(inStationName).put(stationName, new HashMap<String, Integer>());
            }
            int totalTimeTravelled = this.paths.get(inStationName).get(stationName).getOrDefault("time", 0);
            int totalPassengers = this.paths.get(inStationName).get(stationName).getOrDefault("passengers", 0);
            this.paths.get(inStationName).get(stationName).put("time", totalTimeTravelled + t - inTime);
            this.paths.get(inStationName).get(stationName).put("passengers", totalPassengers + 1);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double totalTime = this.paths.get(startStation).get(endStation).getOrDefault("time", 0);
        double totalPassengers = this.paths.get(startStation).get(endStation).getOrDefault("passengers", 0);
        return totalTime / totalPassengers;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */