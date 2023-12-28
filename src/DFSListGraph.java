import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] input = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}}; // 단방향
        int n = 5; // 노드 개수
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>()); // 내부 리스트 초기화 -> 연결된 노드
        }
        for(int[] a : input){
            addEdge(a[0], a[1]);
        }
        dfs(0);
        // 0 > 1 > 3 > 2 > 4
    }

    static void addEdge(int a, int b) { // 단방향을 양방향으로 풀기
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.println(start);
        for(int target : list.get(start)) {
            if(visited[target]==false){
                dfs(target);
            }

        }
    }
}
