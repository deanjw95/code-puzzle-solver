package src.programmers.lv1;

public class 둘만의암호 {

    class Solution {
        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int cnt = getCnt(skip, index, c);
            }

            return answer.toString();
        }
    }

    private static int getCnt(String skip, int index, char c) {
        int cnt = 0;

        for (int j = 1; j <= index; j++) {
            char i1 = (char) (c + j);
            // skip이 i1을 가지고 있다면
            if (skip.contains(String.valueOf(i1))) {
                cnt++;
            }
        }
        return cnt;
    }

    class Solution2 {
        public String solution(String s, String skip, int index) {
            String answer = "";

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for (int j = 0; j < index; j++) {
                    c += 1;
                    if (c > 'z') {
                        c -= 26;
                    }
                    if (skip.contains(String.valueOf(c))) {
                        j--;
                    }
                }
                answer += c;
            }

            return answer;
        }
    }

    /*
위의 Java 코드는 입력 문자열 s, 스킵할 문자열 skip, 그리고 인덱스 index를 받아서 문자열을 변환하는 solution 메서드를 정의하고 있습니다.
이 메서드는 입력 문자열 s의 각 문자를 index 만큼 이동시키는데, 이때 skip 문자열에 포함된 문자는 건너뜁니다.

코드를 간략히 설명하면 다음과 같습니다:

answer 변수는 최종 결과 문자열을 저장하기 위한 빈 문자열로 초기화됩니다.

for 루프를 사용하여 입력 문자열 s의 각 문자를 순회합니다.

내부 for 루프에서 index 만큼 문자를 이동시킵니다.

문자 c에 index를 더합니다.
만약 c가 알파벳 'z'를 넘어가면 'a'부터 다시 시작하도록 처리합니다.
만약 c가 skip 문자열에 포함된 문자라면, j 값을 감소시켜 해당 문자를 건너뜁니다.
내부 for 루프가 종료하면 현재 위치의 문자 c를 answer에 추가합니다.

모든 문자를 처리한 후, 최종 결과 문자열 answer를 반환합니다.

이 코드는 주어진 문자열을 알파벳 문자들을 순환시키면서 지정된 index만큼 이동시키는 암호화나 변환 로직을 구현한 것으로 보입니다.
    * */

}
