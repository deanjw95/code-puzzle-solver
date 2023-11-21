package src.programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 리코쳇로봇 {
    class Solution {
        public int solution(String[] board) {
            int answer = 0;
            Position g = new Position(0, 0);
            Position r = new Position(0, 0);
            List<Position> walls = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                String[] split = board[i].split("");
                for (int j = 0; j < split.length; j++) {
                    if (split[j].equals("G")) {
                        g = new Position(i, j);
                    } else if (split[j].equals("R")) {
                        r = new Position(i, j);
                    } else if (split[j].equals("O")) {
                        walls.add(new Position(i, j));
                    }
                }
            }

            // G 상하좌우에 벽이나 장애물이 있고 움직일 수 있는지 확인
            if (g.x - 1 >= 0 && board[g.x - 1].charAt(g.y) != 'X') {
                // 위로 움직일 수 있음
                // 위로 움직이기
                // R이 위로 움직일 수 있는지 확인
                if (r.x - 1 >= 0 && board[r.x - 1].charAt(r.y) != 'X') {
                    // R도 위로 움직일 수 있음
                    // G, R이 위로 움직임
                    // G, R이 움직인 후 G, R이 O에 도착했는지 확인
                    // G, R이 O에 도착했으면 answer++
                    // G, R이 O에 도착하지 않았으면 다시 원래 위치로 돌아감
                } else {
                    // R은 위로 움직일 수 없음
                    // G만 위로 움직임
                    // G가 움직인 후 G가 O에 도착했는지 확인
                    // G가 O에 도착했으면 answer++
                    // G가 O에 도착하지 않았으면 다시 원래 위치로 돌아감
                }
            }


            return answer;
        }

        class Position {
            int x;
            int y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
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
        public char[][] map;
        public boolean[][] visited;
        public int[] dx = {-1, 0, 1, 0};
        public int[] dy = {0, 1, 0, -1};
        public Pos getPos(int index, Pos now) {
            int x = now.x , y = now.y;
            int ix = dx[index];
            int iy = dy[index];
            while(x + ix >= 0 && x + ix < map.length
                    && y + iy >= 0 && y + iy < map[0].length
                    && map[x + ix][y + iy] != 'D')
            {
                x += ix;
                y += iy;
            }

            return new Pos(x, y, now.level + 1);
        }
        public int bfs(Pos start, Pos goal) {
            Queue<Pos> q = new LinkedList<>();
            visited[start.x][start.y] = true;
            q.add(start);
            while(!q.isEmpty()) {
                Pos now = q.poll();
                int x = now.x;
                int y = now.y;
                int level = now.level;
                if(x == goal.x && y == goal.y)
                    return level;
                for(int i = 0; i < 4; i++) {
                    Pos next = getPos(i, now);
                    if(!visited[next.x][next.y]) {
                        visited[next.x][next.y] = true;
                        q.add(next);
                    }
                }
            }
            return -1;
        }
        public int solution(String[] board) {
            int answer = 0;
            map = new char[board.length][board[0].length()];

            visited = new boolean[map.length][map[0].length];
            Pos start = null;
            Pos goal = null;
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {
                    map[i][j] = board[i].charAt(j);
                    if(map[i][j] == 'R')
                        start = new Pos(i, j, 0);
                    if(map[i][j] == 'G')
                        goal = new Pos(i, j, 0);
                }
            }
            answer = bfs(start, goal);
            return answer;
        }
    }


    /*
     * */
}
