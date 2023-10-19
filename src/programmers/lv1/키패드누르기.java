package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 키패드누르기 {
    class Solution {
        public String solution(int[] numbers, String hand) {

            StringBuilder answer = new StringBuilder();
            int leftPosition = 10;
            int rightPosition = 12;
            Map<Integer, Position> map = new HashMap<>();
            for (int i = 1; i < 13; i++) {
                map.put(i, new Position(i / 3, i % 3));
            }

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    numbers[i] = 11;
                }
                if (numbers[i] % 3 == 1) {
                    answer.append("L");
                    leftPosition = numbers[i];
                } else if (numbers[i] % 3 == 0 ) {
                    answer.append("R");
                    rightPosition = numbers[i];
                } else {
                    int i1 = Math.abs(map.get(leftPosition).x - map.get(numbers[i]).x) + Math.abs(map.get(leftPosition).y - map.get(numbers[i]).y);
                    int i2 = Math.abs(map.get(rightPosition).x - map.get(numbers[i]).x) + Math.abs(map.get(rightPosition).y - map.get(numbers[i]).y);
                    if (i1 < i2) {
                        answer.append("L");
                        leftPosition = numbers[i];
                    } else if (i1 > i2) {
                        answer.append("R");
                        rightPosition = numbers[i];
                    } else {
                        if (hand.equals("left")) {
                            answer.append("L");
                            leftPosition = numbers[i];
                        } else {
                            answer.append("R");
                            rightPosition = numbers[i];
                        }
                    }
                }
            }

            return answer.toString();
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

    class Solution2 {
        //        0부터 9까지 좌표 {y,x}
        int[][] numpadPos = {
                {3,1}, //0
                {0,0}, //1
                {0,1}, //2
                {0,2}, //3
                {1,0}, //4
                {1,1}, //5
                {1,2}, //6
                {2,0}, //7
                {2,1}, //8
                {2,2}  //9
        };
        //초기 위치
        int[] leftPos = {3,0};
        int[] rightPos = {3,2};
        String hand;
        public String solution(int[] numbers, String hand) {
            this.hand = (hand.equals("right")) ? "R" : "L";

            String answer = "";
            for (int num : numbers) {
                String Umji = pushNumber(num);
                answer += Umji;

                if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
                if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
            }
            return answer;
        }

        //num버튼을 누를 때 어디 손을 사용하는가
        private String pushNumber(int num) {
            if(num==1 || num==4 || num==7) return "L";
            if(num==3 || num==6 || num==9) return "R";

            // 2,5,8,0 일때 어디 손가락이 가까운가
            if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
            if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

            //같으면 손잡이
            return this.hand;
        }

        //해당 위치와 번호 위치의 거리
        private int getDist(int[] pos, int num) {
            return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
        }
    }
}
