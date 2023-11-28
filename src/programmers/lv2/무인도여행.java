package src.programmers.lv2;

import java.util.*;

public class 무인도여행 {
    class Solution {
        static char[][] map;
        static boolean[][] visited;
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};

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

        public int[] solution(String[] maps) {
            int[] answer = {};
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[map.length][map[0].length];
            Pos startPos = null;
            for (int i = 0; i < maps.length; i++) {

            }
            return answer;
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
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};
        public static List<Integer> solution(String[] maps){
            List<Integer> answer = new ArrayList<>();
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[map.length][map[0].length];
            for(int i=0;i<maps.length;i++){
                map[i] = maps[i].toCharArray();
            }

            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    if(!visited[i][j] && map[i][j] != 'X'){
                        answer.add(bfs(i, j));
                    }
                }
            }

            if(answer.size() == 0){
                answer.add(-1);
            }
            Collections.sort(answer);
            return answer;
        }

        public static int bfs(int x, int y){
            int sum = 0;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{x, y});
            visited[x][y] = true;

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                sum += map[cx][cy]-'0';
                for(int i=0;i<4;i++){
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];
                    if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                        continue;
                    if(!visited[nx][ny] && map[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            return sum;
        }
    }



    /*
    bfs에 대한 이해도 높일 필요
    * */
}
