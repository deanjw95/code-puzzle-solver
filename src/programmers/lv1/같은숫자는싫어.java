package src.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    class Solution {
        public int[] solution(int []arr) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] != arr[i + 1]) {
                    list.add(arr[i]);
                }
            }
            list.add(arr[arr.length - 1]);

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Solution2 {
        public int[] solution(int []arr) {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            int preNum = 10;
            for(int num : arr) {
                if(preNum != num)
                    tempList.add(num);
                preNum = num;
            }
            int[] answer = new int[tempList.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = tempList.get(i).intValue();
            }
            return answer;
        }
    }
}
