package src.programmers.lv2;


public class 두원사이의정수쌍 {
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            for (int i = 1; i <= r2; i++) {
                for (int j = 1; j <= r2; j++) {
                    int i1 = i * i + j * j;
                    if (i1 >= r1 * r1 && i1 <= r2 * r2) {
                        answer++;
                    }
                }
            }
            return (answer - Math.abs(r1 - r2) - 1) * 4;
        }
    }

    class Solution2 {
        public static long solution(int r1, int r2) {
            long answer = 0;

            for (int x = 1; x <= r2; x++) {
                long minH = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * x * x));
                long maxH = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * x * x));

                System.out.println("x: " + x + ", minH: " + minH + ", maxH: " + maxH);
                answer += (maxH - minH + 1);
            }

            System.out.println("answer: " + answer);

            return answer * 4;
        }
    }

    public static void main(String[] args) {
         Solution2.solution(2, 3);
    }

    /*
for 루프를 통해 x 좌표를 1부터 r2까지 반복합니다.
각 x 좌표에 대해 해당 x 값에서의 최소 높이 minH와 최대 높이 maxH를 계산합니다.
minH는 sqrt(r1^2 - x^2)를 올림한 값입니다.
maxH는 sqrt(r2^2 - x^2)를 내림한 값입니다.
이 부분은 피타고라스의 정리를 이용하여 주어진 반지름과 x 좌표로 높이를 계산하고 있습니다.
각 x 좌표에서의 높이 범위에 해당하는 격자 상의 점의 수를 answer에 더합니다.
이 부분에서 (maxH - minH + 1)은 해당 높이 범위에 속하는 정수로 된 점의 개수입니다.
최종적으로 answer에 4를 곱하여 네 변에 걸친 격자 상의 점의 수를 계산합니다.
이 코드의 목적은, 두 원 사이의 격자 상의 점의 수를 계산하여 반환하는 것으로 보이며,
특히 피타고라스의 정리를 활용하여 각 x 좌표에서의 높이를 계산하고 있습니다.
    * */
}
