package src.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class K번째수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
            int[] answer = {commands.length};

            for (int i = 0; i < commands.length; i++) {
                System.out.println("list.size() = " + list.size());

                int[] command = commands[i];
                List<Integer> tempList = new ArrayList<>(list.subList(command[0] - 1, command[1]));
                Collections.sort(tempList);

                answer[i] = tempList.get(command[2] - 1);
            }

            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }
    }
}
