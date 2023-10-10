package src.programmers.lv1;

import java.util.*;

public class 숫자짝꿍 {

    // 시간 초과
    class Solution {
        public String solution(String X, String Y) {
            String answer = "";

            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < X.length(); i++) {
                xList.add(X.charAt(i) - '0');
            }

            for (int i = 0; i < Y.length(); i++) {
                yList.add(Y.charAt(i) - '0');
            }

            for (int i = 0; i < xList.size(); i++) {
                if (yList.contains(xList.get(i))) {
                    priorityQueue.offer(xList.get(i));
                    yList.remove(xList.get(i));
                }
            }
            if (priorityQueue.isEmpty()) {
                return "-1";
            } else {
                while (!priorityQueue.isEmpty()) {
                    answer += priorityQueue.poll();
                }
            }

            // answer가 0으로만 구성돼있다면
            if (answer.matches("0+")) {
                return "0";
            }

            return answer;
        }
    }

    class Solution2 {
        public String solution(String X, String Y) {
            StringBuilder answer = new StringBuilder();
            int[] x = {0,0,0,0,0,0,0,0,0,0};
            int[] y = {0,0,0,0,0,0,0,0,0,0};
            for(int i=0; i<X.length();i++){
                x[X.charAt(i)-48] += 1;
            }
            for(int i=0; i<Y.length();i++){
                y[Y.charAt(i)-48] += 1;
            }

            for(int i=9; i >= 0; i--){
                for(int j=0; j<Math.min(x[i],y[i]); j++){
                    answer.append(i);
                }
            }
            if("".equals(answer.toString())){
                return "-1";
            }else if(answer.toString().charAt(0)==48){
                return "0";
            }else {
                return answer.toString();
            }
        }
    }

}
