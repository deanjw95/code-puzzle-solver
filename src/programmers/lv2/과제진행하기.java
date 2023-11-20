package src.programmers.lv2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class 과제진행하기 {
    class Solution {
        public String[] solution(String[][] plans) {
            Arrays.sort(plans, (p1, p2) -> LocalTime.parse(p1[1]).compareTo(LocalTime.parse(p2[1])));
            Stack<Plan> stack = new Stack<>();
            List<String> answer = new ArrayList<>();

            for (int i = 0; i < plans.length - 1; i++) {
                Plan plan = new Plan(plans[i][0], plans[i][1], plans[i][2]);
                LocalTime nextPlanStart = LocalTime.parse(plans[i + 1][1]);
                int gap = (int) ChronoUnit.MINUTES.between(plan.getStart(), nextPlanStart);

                if (isFinished(gap, plan.getPlayTime())) {
                    answer.add(plan.getName());
                    if (hasExtraTime(gap, plan)) {
                        playUnfinishedPlan(stack);
                    }
                } else {
                    pushUnfinishedPlan(plan, gap, stack);
                }
            }



            return answer.toArray(new String[0]);
        }

        private static boolean hasExtraTime(int gap, Plan plan) {
            return gap - plan.getPlayTime() > 0;
        }

        private static void playUnfinishedPlan(Stack<Plan> stack) {
            while (!stack.isEmpty()) {
                Plan previousPlan = stack.peek();
                if (isFinished(previousPlan, stack.peek())) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        private static void pushUnfinishedPlan(Plan plan, int gap, Stack<Plan> stack) {
            plan.setPlayTime(plan.getPlayTime() - gap);
            stack.push(plan);
        }

        private static boolean isFinished(int gap, int playTime) {
            return gap >= playTime;
        }

        private static boolean isFinished(Plan previousPlan, Plan plan) {
            return previousPlan.getStart().plusMinutes(previousPlan.getPlayTime()).isBefore(plan.getStart());
        }

        class Plan {
            String name;
            LocalTime start;
            int playTime;

            public Plan(String name, String start, String playTime) {
                this.name = name;
                this.start = LocalTime.parse(start);
                this.playTime = Integer.parseInt(playTime);
            }

            public String getName() {
                return name;
            }

            public LocalTime getStart() {
                return start;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }
        }
    }


    class Solution2 {
        class Subject implements Comparable<Subject>{
            String name;
            int start, playtime;
            Subject(String name, int start, int playtime){
                this.name = name;
                this.start = start;
                this.playtime = playtime;
            }

            @Override
            public int compareTo(Subject s){
                return this.start - s.start; //시작시간 오름차순 정렬
            }
        }


        public String[] solution(String[][] plans) {
            String[] answer = {};
            //과제를 끝낸 순서대로 이름을 배열에 담아 return
            //새로 시작한 과제 -> 중간에 멈춘 과제

            answer = new String[plans.length];
            int idx = 0;
            PriorityQueue<Subject> q = new PriorityQueue<>((o1, o2)->(o1.start-o2.start));
            for(String[] p:plans){
                q.add(new Subject(p[0], convertTime(p[1]), Integer.parseInt(p[2])));
            }

            Subject s = q.poll();
            int now = s.start;

            Stack<Subject> stack = new Stack<>(); //멈춘 과제들
            while(true){
                if(!q.isEmpty() && now+s.playtime > q.peek().start){
                    //과제 중지
                    stack.push(new Subject(s.name, s.start, s.playtime-(q.peek().start-now)));

                    now = q.peek().start;

                    s = q.poll(); //새로운 과제 시작
                }
                else{
                    //과제 끝냄
                    answer[idx++] = s.name;
                    now += s.playtime;

                    //새로 시작해야 하는 과제가 있다면 새로운 과제 시작
                    if(!q.isEmpty() && now==q.peek().start){
                        s = q.poll();
                    }
                    else if(!stack.isEmpty()){
                        //멈춰둔 과제 다시 시작
                        s = stack.pop();
                    }
                    else if(!q.isEmpty()){
                        s = q.poll();
                        now = s.start;
                    }
                    else break;
                }
            }

            return answer;
        }

        public static int convertTime(String t){
            String[] str = t.split(":");
            int min = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            return min;
        }
    }


    /*
    * */
}
