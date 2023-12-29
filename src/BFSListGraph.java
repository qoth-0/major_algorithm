import java.util.*;

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
//class Solution {
//    static List<List<Integer>> list;
//    static boolean[] visited;
//    static int[] distance;
//    public int solution(int[][] maps) {
//        int m = maps.length;
//        int n = maps[0].length;
//        visited = new boolean[m*n];
//        distance = new int[m*n];
//        list = new ArrayList<>();
//        Arrays.fill(distance, 1);
//
//        for(int i=0; i<m*n; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        for(int i=0; i<m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(maps[i][j]==0) continue;
//                int dx[] = {-1, 1, 0, 0};
//                int dy[] = {0, 0, -1, 1};
//                for (int k = 0; k < 4; k++) {
//                    int target_i = i + dx[k];
//                    int target_j = j + dy[k];
//                    if (target_i < m && target_i >= 0  && target_j < n && target_j >= 0 && maps[target_i][target_j]==1){
//                        addEdge(i*n+j, target_i*n+target_j);
//                    }
//                }
//            }
//        }
//        int answer = bfs(0, n*m-1);
//        return answer;
//    }
//    static void addEdge(int a, int b) { // 단방향을 양방향으로 풀기
//        list.get(a).add(b);
//        list.get(b).add(a);
//    }
//
//
//    static int bfs(int start, int end) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        visited[start] = true;
//        while (!queue.isEmpty()) {
//            int now = queue.poll(); // 현재 위치를 꺼내면서(방문)
//            for (int next : list.get(now)) {
//                if (visited[next] != true) {
//                    queue.add(next); // 이어진 노드(방문예정)를 큐에 삽입
//                    distance[next] = distance[now] + 1; // 직전 노드의 거리 + 1
//                    visited[next] = true;
//                    if (next == end) { // 도착지점이 담기면 종료
//                        return distance[next];
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}


// 프로그래머스 : 가장 먼 노드

//class Solution {
//    static List<List<Integer>> list = new ArrayList<>();
//    static boolean[] visited;
//    static int[] distance;
//    public int solution(int n, int[][] edge) {
//        int answer = 0;
//        int max = 0;
//
//        visited = new boolean[n+1];
//        distance = new int[n+1];
//
//        for(int i=0; i<=n; i++) {
//            list.add(new ArrayList<>());
//        }
//        for(int[] a : edge) {
//            addEdge(a[0], a[1]);
//        }
//        bfs(1);
//
//        for(int a : distance) {
//            if(max < a) {
//                max = a;
//            }
//        }
//
//        for(int a : distance) {
//            if(a == max) {
//                answer++;
//            }
//        }
//
//////        람다로 표현
////        int max = Arrays.stream(distance).max().getAsInt();
////        int answer = (int) Arrays.stream(distance).filter(a->a==max).count();
//
//        return answer;
//    }
//    static void addEdge(int a, int b) { // 단방향을 양방향으로 풀기
//        list.get(a).add(b);
//        list.get(b).add(a);
//    }
//
//    static void bfs(int start) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        visited[start] = true;
//        while (!queue.isEmpty()) {
//            int now = queue.poll(); // 현재 위치를 꺼내면서(방문)
//            for (int next : list.get(now)) {
//                if (visited[next] != true) {
//                    queue.add(next); // 이어진 노드(방문예정)를 큐에 삽입
//                    distance[next] = distance[now] + 1; // 직전 노드의 거리 + 1
//                    visited[next] = true;
//                }
//            }
//        }
//    }
//}

