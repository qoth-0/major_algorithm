import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
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
        bfs(0);
        // 0 > 1 > 2 > 3 > 4

    }
    static void addEdge(int a, int b) { // 단방향을 양방향으로 풀기
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(next + " ");
            for(int target : list.get(next)) {
                if(visited[target] != true){
                    queue.add(target);
                    visited[target] = true;
                }
            }
        }

    }

}
