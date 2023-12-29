import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSListGraph {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
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

        distance = new int[n];

        int shortest = bfs(0, 3);
        // 0 > 1 > 2 > 3 > 4
        System.out.println(shortest);

    }
    static void addEdge(int a, int b) { // 단방향을 양방향으로 풀기
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 위치를 꺼내면서(방문)
//            System.out.print(next + " "); // 방문 순서 출력
            for (int next : list.get(now)) {
                if (visited[next] != true) {
                    queue.add(next); // 이어진 노드(방문예정)를 큐에 삽입
                    distance[next] = distance[now] + 1; // 직전 노드의 거리 + 1
                    visited[next] = true;
                    if (next == end) { // 도착지점이 담기면 종료
                        return distance[next];
                    }
                }
            }

        }
        return -1;
    }

}

// 프로그래머스 : 게임 맵 최단거리

