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

// 프로그래머스 : 네트워크
class Solution {
    static boolean[] visited;
    static int count = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(visited[i]!=true) {
                dfs(i, computers);
                count++; // bfs가 시작될때마다 count
            }
        }

        return count;
    }
    static void dfs(int start, int[][] computers) {
        visited[start] = true;
        for(int i=0; i< computers[start].length; i++) {
            if(visited[i]!=true && computers[start][i]==1){
                dfs(i, computers);
            }
        }
    }
}
