package src.programmers.lv2;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class 미로탈출 {
    class Solution {
        public int solution(String[] maps) {
            char[][] map = new char[maps.length][maps[0].length()];
            Position start = new Position(0, 0, 0);
            Position lever = new Position(0, 0, 0);

            for (int i = 0; i < maps.length; i++) {
                String[] split = maps[i].split("");
                for (int j = 0; j < split.length; j++) {
                    map[i][j] = split[j].charAt(0);
                    if (map[i][j] == 'S') {
                        start = new Position(i, j, 0);
                    } else if (map[i][j] == 'L') {
                        lever = new Position(i, j, 0);
                    }
                }
            }

            Graph graph = new Graph(maps[0].length(), maps.length, map);
            return graph.dfs(start, lever);
        }

        class Graph {
            private int width;
            private int height;
            private char[][] map;

            public Graph(int width, int height, char[][] map) {
                this.width = width;
                this.height = height;
                this.map = map;
            }

            public int dfs(Position start, Position lever) {
                boolean[][] visited = new boolean[height][width];
                int sToL = dfsRecursive(start, visited, lever);

                if (sToL == Integer.MAX_VALUE) {
                    return -1;
                }

                return sToL;
            }

            private int dfsRecursive(Position currentPosition, boolean[][] visited, Position target) {
                visited[currentPosition.x][currentPosition.y] = true;

                if (currentPosition.equals(target)) {
                    return currentPosition.level;
                }

                int result = Integer.MAX_VALUE;

                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                // 동 서 남 북
                for (int i = 0; i < directions.length; i++) {
                    int[] direction = directions[i];
                    int nextX = currentPosition.x + direction[0];
                    int nextY = currentPosition.y + direction[1];

                    if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width) {
                        if (!visited[nextX][nextY] && map[nextX][nextY] != 'X') {
                            result = Math.min(result, dfsRecursive(new Position(nextX, nextY, currentPosition.level + 1), visited, target));
                        }
                    }
                }

                return result;
            }
        }

        class Position {
            int x;
            int y;
            int level;

            public Position(int x, int y, int level) {
                this.x = x;
                this.y = y;
                this.level = level;
            }

            // Position 객체가 같은 위치를 나타내는지 확인
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Position position = (Position) obj;
                return x == position.x && y == position.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }

    class Pos {
        int x, y;
        int level;
        Pos(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    class Solution2 {
        static char[][] map;
        static boolean[][] visited;
        static int[] dx = {-1,0,1,0};
        static int[] dy = {0,1,0,-1};
        public int bfs(int startX, int startY, int H, int W, int EndX, int EndY) {
            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(startX, startY, 0));
            visited[startX][startY] = true;
            while(!q.isEmpty()) {
                Pos now = q.poll();
                int x = now.x;
                int y = now.y;
                int level = now.level;
                if(x == EndX && y == EndY)
                {
                    return level;
                }

                for(int i = 0; i < 4; i++) {
                    int nowX = x + dx[i];
                    int nowY = y + dy[i];
                    if(nowX < 0 || nowX >= H || nowY < 0 || nowY >= W)
                        continue;
                    if(!visited[nowX][nowY] && map[nowX][nowY] != 'X')
                    {
                        q.add(new Pos(nowX, nowY, level + 1));
                        visited[nowX][nowY] = true;
                    }
                }
            }
            return -1;
        }
        public int solution(String[] maps) {
            int answer = 0;
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[map.length][map[0].length];
            Pos startPos = null;
            Pos leverPos = null;
            Pos endPos = null;
            for(int i = 0; i < maps.length; i++) {
                for(int j = 0; j < maps[i].length(); j++) {
                    if(maps[i].charAt(j) == 'S')
                        startPos = new Pos(i, j, 0);
                    if(maps[i].charAt(j) == 'L')
                        leverPos = new Pos(i, j, 0);
                    if(maps[i].charAt(j) == 'E')
                        endPos = new Pos(i, j, 0);
                    map[i][j] = maps[i].charAt(j);
                }
            }
            answer = bfs(startPos.x, startPos.y, maps.length, maps[0].length(), leverPos.x, leverPos.y);
            if(answer > -1)
            {
                visited = new boolean[map.length][map[0].length];

                int temp = bfs(leverPos.x, leverPos.y, maps.length, maps[0].length(), endPos.x, endPos.y);
                if(temp == -1)
                    answer = -1;
                else
                    answer += temp;
            }
            return answer;
        }
    }


    /*
    DFS 문제인줄 알았으나 BFS로 풀어야 했던 문제
     * */
}
