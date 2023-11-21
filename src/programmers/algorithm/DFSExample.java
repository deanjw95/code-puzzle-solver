package src.programmers.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSExample {


    static class Graph {
        private int vertices;
        private List<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        // 그래프에 간선 추가
        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            // 무방향 그래프인 경우 아래 주석 처리된 코드를 추가로 사용
            // adjacencyList[destination].add(source);
        }

        // 재귀를 통한 DFS 탐색
        private void dfsRecursive(int currentVertex, boolean[] visited) {
            visited[currentVertex] = true;
            System.out.println("Visit: " + currentVertex);

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    dfsRecursive(neighbor, visited);
                }
            }
        }

        // 외부에서 호출되는 DFS 메서드
        public void dfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            dfsRecursive(startVertex, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("DFS starting from vertex 0:");
        graph.dfs(0);
    }
}