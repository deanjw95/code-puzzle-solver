package src.programmers.highscorekit.stackqueue;

import java.util.*;
import java.util.stream.Collectors;

public class 기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            Queue<Integer> queue = Arrays.stream(progresses)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));
            Queue<Integer> speedQueue = Arrays.stream(speeds)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));

            int day = 0;

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                Integer speedPoll = speedQueue.poll();
                day += getRemain(poll, speedPoll);
                int count = 1;

                while (!queue.isEmpty() && !speedQueue.isEmpty() &&
                        queue.peek() + day * speedQueue.peek() >= 100) {
                    queue.poll();
                    speedQueue.poll();
                    count++;
                }

                answer.add(count);
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }

        private int getRemain(int progress, int speed) {
            return (int) Math.ceil((100.0 - progress) / speed);
        }
    }

    class Solution2 {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<progresses.length; i++){
                queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
            }

            List<Integer> answer = new ArrayList<>();
            while (!queue.isEmpty()){
                int day = queue.poll();
                int cnt = 1;

                while(!queue.isEmpty() && day >= queue.peek()){
                    cnt++;
                    queue.poll();
                }
                answer.add(cnt);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }


    /*
     * */
}
