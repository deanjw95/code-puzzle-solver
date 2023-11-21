package src.programmers.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {

    static class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        // 그래프에 간선 추가
        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source); // 무방향 그래프인 경우
        }

        // BFS 탐색
        public void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.offer(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.println("Visit: " + currentVertex);

                for (int neighbor : adjacencyList[currentVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("BFS starting from vertex 0:");
        graph.bfs(0);
    }
}