package src.programmers.highscorekit.stackqueue;

import java.util.*;

public class 프로세스 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            for (int priority : priorities) {
                queue.add(priority);
            }

            int loop = 0;
            int cnt = 0;

            while (!queue.isEmpty()) {
                int current = queue.peek();
                int a = loop % priorities.length;

                if (current == priorities[a]) {
                    queue.poll();
                    cnt++;
                    if (a == location) {
                        answer = cnt;
                        break;
                    }
                }

                loop++;
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int l = location;

            Queue<Integer> que = new LinkedList<Integer>();
            for(int i : priorities){
                que.add(i);
            }

            Arrays.sort(priorities);
            int size = priorities.length-1;



            while(!que.isEmpty()){
                Integer i = que.poll();
                if(i == priorities[size - answer]){
                    answer++;
                    l--;
                    if(l <0)
                        break;
                }else{
                    que.add(i);
                    l--;
                    if(l<0)
                        l=que.size()-1;
                }
            }

            return answer;
        }
    }


    /*
    * */
}
