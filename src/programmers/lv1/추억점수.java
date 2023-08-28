package programmers.lv1;
import java.util.*;

public class 추억점수 {

    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            Map<String, Integer> yearningMap = new HashMap<>();
            for (int i = 0; i < name.length; i++) {
                yearningMap.put(name[i], yearning[i]);
            }

            int[] result = new int[photo.length];
            for (int i = 0; i < photo.length; i++) {
                int totalScore = 0;
                for (String person : photo[i]) {
                    if (yearningMap.containsKey(person)) {
                        totalScore += yearningMap.get(person);
                    }
                }
                result[i] = totalScore;
            }

            return result;
        }
    }

    class Solution2 {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];
            for(int i = 0; i < photo.length; i++){
                for(int j = 0; j < photo[i].length; j++){
                    for(int k = 0; k < name.length; k++){
                        if(photo[i][j].equals(name[k])) answer[i] += yearning[k];
                    }
                }
            }
            return answer;
        }
    }

    /*
        Solution 클래스와 Solution2 클래스의 두 함수는 똑같은 목표를 가지고 있지만, 구현 방식이 조금 다릅니다.

        Solution 클래스의 solution 함수는 입력 배열들을 Map을 활용하여 사람 이름과 그리움 점수를 연결하고, 각 사진에 대해 해당하는 인물의 그리움 점수를 확인하여 합산하는 방식으로 구현되었습니다. 이 방식은 중복되는 이름을 효과적으로 처리할 수 있으며, 빠른 검색을 통해 그리움 점수를 가져올 수 있습니다.

        Solution2 클래스의 solution 함수는 루프를 이용하여 입력 배열들을 순회하며 각 사진에 대한 그리움 점수를 계산합니다. 사진 내의 인물 이름을 전체 이름 배열과 비교하여 매칭되는 경우 해당하는 그리움 점수를 더하는 방식으로 구현되었습니다. 이 방식은 간단하지만, 중복된 이름을 처리하는 데에는 약간 비효율적일 수 있습니다.

        두 방식 모두 동작은 동일하며, Solution 클래스의 방식이 중복된 이름 처리나 빠른 검색에 더 효율적일 수 있습니다. 그러나 입력 데이터의 크기나 상황에 따라 두 방식 중 어느 것을 선택할지 판단하실 수 있습니다.
     */
}
