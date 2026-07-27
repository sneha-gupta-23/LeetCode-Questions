class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    public void dfs(int[][] graph, boolean[] visited, int city){
        visited[city] = true;
        for(int neigh=0; neigh<graph.length; neigh++){
            if(graph[city][neigh] == 1 && !visited[neigh]){
                dfs(graph, visited, neigh);
            }
        }
    }
}