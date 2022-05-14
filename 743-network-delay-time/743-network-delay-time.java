class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> graph;
    
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }    
        System.out.println();
    }
    
    public void dfs(int src, boolean[] vis, int[] timesTaken, int time) {
        vis[src] = true;
        if (graph.containsKey(src)) {
            for (Map.Entry<Integer, Integer> nbrs : graph.get(src).entrySet()) {
                int nbr = nbrs.getKey(), nbrTime = nbrs.getValue();
                if (!vis[nbr]) {
                    if (time + nbrTime < timesTaken[nbr]) {
                        timesTaken[nbr] = time + nbrTime;
                        dfs(nbr, vis, timesTaken, time + nbrTime);
                    }
                }
            }
        }
        vis[src] = false;
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new HashMap<>();
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (!graph.containsKey(u)) {
                graph.put(u, new HashMap<>());
            }
            graph.get(u).put(v, w);
        }
        
        boolean[] vis = new boolean[n + 1];
        int[] timesTaken = new int[n + 1];
        Arrays.fill(timesTaken, Integer.MAX_VALUE);
        timesTaken[k] = 0;
        dfs(k, vis, timesTaken, 0);
        
        // printArray(timesTaken);
        int ans = timesTaken[1];
        for (int i = 1; i <= n; i++) {
            if (timesTaken[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, timesTaken[i]);
        }
        return ans;
    }
}