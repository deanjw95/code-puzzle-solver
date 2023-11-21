package src.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 광물캐기 {
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            int cnt = 0;
            List<Integer> list = new ArrayList<>();

            while (cnt < picks.length) {
                int sum = 0;
                int groupSize = Math.min(5, picks.length - cnt);

                for (int i = cnt; i < cnt + groupSize; i++) {
                    sum += picks[i];
                }

                list.add(sum);
                cnt += 5;
            }

            int idx = Arrays.stream(picks).sum();
            if (idx < list.size()) {
                // idx 길이만큼 자르기
                list = list.subList(0, idx);
            }

            // 큰 순서대로 list 정렬
            list.sort((o1, o2) -> o2 - o1);

            for (int i = 0; i < idx; i++) {

            }


            return answer;
        }
    }


    class Solution2 {

        static class Mineral {
            private int diamond;
            private int iron;
            private int stone;

            public Mineral(int diamond, int iron, int stone) {
                this.diamond = diamond;
                this.iron = iron;
                this.stone = stone;
            }
        }

        static int[][] scoreBoard;
        static List<Mineral> list;

        public int solution(int[] picks, String[] minerals) {
            int answer = 0;

            scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

            int totalPicks = Arrays.stream(picks).sum();
            list = new ArrayList<>();
            for(int i = 0; i < minerals.length; i+=5) {
                if(totalPicks == 0) break;

                int dia = 0, iron = 0, stone = 0;
                for(int j = i; j < i + 5; j++) {
                    if(j == minerals.length) break;

                    String mineral = minerals[j];
                    int val = mineral.equals("iron") ? 1 :
                            mineral.equals("stone") ? 2 : 0;

                    dia += scoreBoard[0][val];
                    iron += scoreBoard[1][val];
                    stone += scoreBoard[2][val];
                }

                list.add(new Mineral(dia, iron, stone));
                totalPicks--;
            }

            Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
            for(Mineral m : list) {
                int dia = m.diamond;
                int iron = m.iron;
                int stone = m.stone;

                if(picks[0] > 0) {
                    answer += dia;
                    picks[0]--;
                    continue;
                }
                if(picks[1] > 0) {
                    answer += iron;
                    picks[1]--;
                    continue;
                }
                if(picks[2] > 0) {
                    answer += stone;
                    picks[2]--;
                    continue;
                }
            }

            return answer;
        }
    }

    /*
이 코드는 어떤 게임에서 일정한 조건에 따라 다양한 광물을 캐는 것에 대한 점수를 계산하는 문제를 해결하는 자바 클래스 `Solution2`를 구현한 것으로 보입니다.
코드에서 `Mineral` 클래스는 각 광물의 다이아몬드, 철, 돌에 대한 점수를 저장하는 데 사용됩니다.

여기서 코드의 핵심 로직은 `solution` 메서드에 구현되어 있습니다. 몇 가지 주요 요소는 다음과 같습니다:

1. **scoreBoard 배열:** 광물의 종류와 각 광물에 대한 다이아몬드, 철, 돌의 점수가 2차원 배열로 정의되어 있습니다.

2. **picks 배열과 minerals 배열:** `picks` 배열은 플레이어가 선택한 광물의 개수를 나타내고, `minerals` 배열은 캐릭터가 채굴한 광물의 종류를 나타냅니다.

3. **list:** 각 광물에 대한 점수를 저장하는 `Mineral` 객체를 담는 리스트입니다.

4. **광물의 점수 계산:** `minerals` 배열에서 읽어온 각 광물의 종류에 따라 `scoreBoard`를 참조하여 다이아몬드, 철, 돌에 대한 점수를 계산하고, 이를 `Mineral` 객체로 만들어 리스트에 추가합니다.

5. **리스트 정렬:** 리스트를 돌며 돌의 점수를 기준으로 내림차순으로 정렬합니다.

6. **플레이어가 선택한 광물에 따라 점수 산정:** 리스트를 순회하면서 플레이어가 선택한 광물의 개수에 따라 다이아몬드, 철, 돌의 점수를 합산하고, 이를 최종적으로 반환합니다.

코드를 간단히 설명하면, 주어진 광물과 선택한 광물에 대한 점수를 계산하고, 돌의 점수를 기준으로 내림차순으로 정렬한 후 플레이어가 선택한 광물에 따라 최종 점수를 계산하는 것입니다.

https://velog.io/@seowj0710/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%EA%B4%91%EB%AC%BC-%EC%BA%90%EA%B8%B0-Java
    * */
}
