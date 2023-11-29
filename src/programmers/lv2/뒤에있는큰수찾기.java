package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                int now = numbers[i];
                boolean flag = false;
                for (int j = i + 1; j < numbers.length; j++) {
                    if (now < numbers[j]) {
                        answer[i] = numbers[j];
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    answer[i] = -1;
                }
            }
            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> s = new Stack<>();

            for(int i=numbers.length-1; i>=0; i--){
                while(!s.isEmpty()){
                    if(s.peek() > numbers[i]){
                        answer[i] = s.peek();
                        break;
                    }else{
                        s.pop();
                    }
                }
                if(s.isEmpty()){
                    answer[i] = -1;
                }
                s.push(numbers[i]);
            }
            return answer;

        }
    }


    /*
    stack을 사용한 풀이
    * */
}
