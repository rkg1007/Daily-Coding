class Solution {
    public boolean dfs(int[][] graph, int[] colors, int curr, int color) {
        if (colors[curr] != 0) return colors[curr] == color;
        
        colors[curr] = color;
        for (int i = 0; i < graph[curr].length; i++) {
            int nbr = graph[curr][i];
            if (!dfs(graph, colors, nbr, color * -1)) return false;
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) return false;
        }
        return true;
    }
}