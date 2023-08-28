package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 공원산책 {

    class Solution2 {
        public int[] solution(String[] park, String[] routes) {
            int sx = 0;
            int sy = 0;

            char[][] arr = new char[park.length][park[0].length()];

            for(int i = 0; i < park.length; i++){
                arr[i] = park[i].toCharArray();

                if(park[i].contains("S")){
                    sy = i;
                    sx = park[i].indexOf("S");
                }
            }

            for(String st : routes){
                String way = st.split(" ")[0];
                int len = Integer.parseInt(st.split(" ")[1]);

                int nx = sx;
                int ny = sy;

                for(int i = 0; i < len; i++){
                    if(way.equals("E")){
                        nx++;
                    }
                    if(way.equals("W")){
                        nx--;
                    }
                    if(way.equals("S")){
                        ny++;
                    }
                    if(way.equals("N")){
                        ny--;
                    }
                    if(nx >=0 && ny >=0 && ny < arr.length && nx < arr[0].length){
                        if(arr[ny][nx] == 'X'){
                            break;
                        }
                        // 범위내 & 장애물 x
                        if(i == len-1){
                            sx = nx;
                            sy = ny;
                        }
                    }
                }
            }

            int[] answer = {sy, sx};
            return answer;
        }
    }

    /*
        위 코드는 주어진 park와 routes 배열을 사용하여 로봇 강아지가 주어진 명령을 수행하며 이동한 결과 위치를 계산하는 solution 함수를 구현한 것입니다.
        아래는 코드의 각 부분에 대한 설명입니다:

        sx와 sy는 로봇 강아지의 초기 위치를 나타내는 변수입니다.
        2차원 배열 arr은 공원의 상태를 나타내는 배열입니다. 각 문자열을 문자 배열로 변환하여 arr에 저장하면서, 초기 위치도 찾아서 sx, sy에 저장합니다.
        routes 배열을 순회하면서 각 명령을 처리합니다.
        way 변수는 현재 명령에서의 이동 방향을 나타내며, len 변수는 이동할 거리를 나타냅니다.
        nx와 ny는 현재 위치의 x, y 좌표를 나타냅니다.
        for 루프를 이용하여 로봇 강아지가 주어진 거리만큼 이동하도록 합니다.
        이동할 때마다 범위 내에 있고, 장애물이 없는지 확인합니다.
        이동 거리를 모두 수행한 경우, 새로운 위치를 sx와 sy에 저장합니다.
        마지막으로 로봇 강아지의 최종 위치를 answer 배열에 저장하여 반환합니다.
        이 코드는 주어진 명령을 처리하면서 로봇 강아지의 위치를 업데이트하는 방식으로 문제를 해결합니다.
        로봇 강아지가 공원의 경계를 넘거나 장애물을 만나면 해당 명령을 무시하고 다음 명령을 수행합니다. 최종적으로 로봇 강아지의 위치를 배열로 반환합니다.
     */
}
