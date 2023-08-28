package programmers.lv1;
import java.util.*;

public class 달리기경주 {

    static class Solution {
        public String[] solution(String[] players, String[] callings) {
            ArrayList<String> playerList = new ArrayList<>(Arrays.asList(players));
            ArrayList<String> callingList = new ArrayList<>(Arrays.asList(callings));

            for (String calling : callingList) {
                int idx = playerList.indexOf(calling);
                Collections.swap(playerList, idx-1, idx);
            }

            return playerList.toArray(new String[0]);
        }
    }

    static class Solution2 {
        public String[] solution(String[] players, String[] callings) {
            int n = players.length;
            HashMap<String, Integer> indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                indexMap.put(players[i], i);
            }

            for (String calling : callings) {
                int idx = indexMap.get(calling);
                if (idx > 0) {
                    String temp = players[idx - 1];
                    players[idx - 1] = players[idx];
                    players[idx] = temp;

                    indexMap.put(players[idx - 1], idx - 1);
                    indexMap.put(players[idx], idx);
                }
            }

            return players;
        }
    }

    /*
        두 Solution 클래스 모두 주어진 players 배열과 callings 배열에 대해 주어진 조건에 따라 선수들의 등수를 계산하는 방법을 구현한 것 같습니다. 그러나 두 방법은 약간 다른 접근 방식을 사용하고 있습니다.

        Solution 클래스의 첫 번째 방법은 ArrayList와 Collections.swap을 사용하여 선수들의 등수를 계산합니다. 두 번째 방법은 HashMap을 사용하여 선수들의 인덱스를 관리하며, players 배열 내에서 직접 원소의 위치를 변경하는 방식을 사용합니다.

        두 방법의 차이점:

        데이터 구조: 첫 번째 방법은 ArrayList와 Collections.swap을 사용하여 선수들의 등수를 계산하고, 두 번째 방법은 players 배열과 HashMap을 사용합니다.

        성능: 성능 측면에서는 두 번째 방법이 상대적으로 더 효율적일 수 있습니다. ArrayList의 indexOf 메서드는 선형 탐색을 사용하기 때문에 최악의 경우 O(n) 시간이 소요될 수 있습니다. 반면에 두 번째 방법은 HashMap을 사용하여 원소의 위치를 빠르게 찾을 수 있기 때문에 더 빠른 성능을 기대할 수 있습니다.

        메모리 사용: 두 번째 방법은 HashMap을 사용하여 인덱스를 저장하기 때문에 약간의 추가 메모리를 사용합니다. 반면에 첫 번째 방법은 ArrayList와 Collections.swap만을 사용하므로 추가 메모리 사용이 적습니다.

        두 방법 모두 원하는 결과를 달성하기 위해 다른 방식으로 작성되었으며, 선택하는 방법은 코드의 가독성, 성능 요구 사항 및 개발자의 선호도에 따라 다를 수 있습니다.
     */
}
