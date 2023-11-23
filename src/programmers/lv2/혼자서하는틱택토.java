package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 혼자서하는틱택토 {
    class Solution {
        public int solution(String[] board) {
            int answer = -1;
            List<Position> os = new ArrayList<>();
            List<Position> xs = new ArrayList<>();


            for (int i = 0; i < board.length; i++) {
                String[] split = board[i].split("");
                for (int j = 0; j < split.length; j++) {
                    if (split[j].equals("O")) {
                        os.add(new Position('O', i, j));
                    } else if (split[j].equals("X")) {
                        xs.add(new Position('X', i, j));
                    }
                }
            }

            // X가 O보다 많은 경우 -1
            if (xs.size() > os.size()) {
                return -1;
            }

            // 3개를 완성한 경우
            // 3개의 O를 완성했을 때 X는 O보다 작음
            // 3개의 X를 완성했을 때 O는 X와 같음

            return answer;
        }

        class Position {
            char c;
            int x;
            int y;

            public Position(char c, int x, int y) {
                this.c = c;
                this.x = x;
                this.y = y;
            }
        }
    }

    class Solution2 {
        public int solution(String[] board) {
            int Ocnt = 0;
            int Xcnt = 0;
            //O와 X의 개수를 센다.
            for (int i = 0; i < 3; i++) {
                Ocnt += countChar(board[i], 'O');
                Xcnt += countChar(board[i], 'X');
            }

            //'X'가 'O'보다 많으면 규칙 위반
            if (Xcnt > Ocnt) {
                return 0;
            }

            //'O'가 'X'보다 2개이상 많으면 규칙 위반
            if (Ocnt > Xcnt + 1) {
                return 0;
            }

            //O가 완성 되었을 때 X가 O의 개수와 같으면 규칙 위반
            if (hasWin(board, 'O')) {
                if (Ocnt == Xcnt) {
                    return 0;
                }
            }
            //X가 완성 되었을 때 O가 X보다 1개 많으면 규칙 위반
            if (hasWin(board, 'X')) {
                if (Ocnt == Xcnt + 1) {
                    return 0;
                }
            }
            return 1;
        }

        private static int countChar(String str, char ch) {
            return str.length() - str.replace(String.valueOf(ch), "").length();
        }

        private static boolean hasWin(String[] board, char ch) {
            //가로 검사
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(0) == ch
                        && board[i].charAt(1) == ch
                        && board[i].charAt(2) == ch) {
                    return true;
                }
            }
            //세로 검사
            for (int i = 0; i < 3; i++) {
                if (board[0].charAt(i) == ch
                        && board[1].charAt(i) == ch
                        && board[2].charAt(i) == ch) {
                    return true;
                }
            }
            //대각선 검사
            if (board[0].charAt(0) == ch
                    && board[1].charAt(1) == ch
                    && board[2].charAt(2) == ch) {
                return true;
            }
            if (board[0].charAt(2) == ch
                    && board[1].charAt(1) == ch
                    && board[2].charAt(0) == ch) {
                return true;
            }
            return false;
        }
    }

    /*
     * */
}
