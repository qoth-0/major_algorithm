public class DFSArrayGraph {
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) {

      graph = new int[][]{
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0}};
        visited = new boolean[graph.length];
        dfs( 0);
        // 0 > 1 > 3 > 2 > 4

    }
    static void dfs(int start) {
        visited[start] = true;
        System.out.println(start);
        for(int i=0; i<graph[start].length; i++) {
            if(visited[i]==false && graph[start][i]==1){
                dfs(i);
            }
        }
    }
}
