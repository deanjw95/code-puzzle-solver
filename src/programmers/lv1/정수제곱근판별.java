package src.programmers.lv1;

public class 정수제곱근판별 {
    class Solution {
        public long solution(long n) {
            long answer = -1;
            long i = 1;
            while (i * i <= n) {
                if (i * i == n) {
                    return answer = (i + 1) * (i + 1);
                }
                i++;
            }
            return answer;
        }
    }

    class Solution2 {
        public long solution(long n) {
            if (Math.pow((int)Math.sqrt(n), 2) == n) {
                return (long) Math.pow(Math.sqrt(n) + 1, 2);
            }

            return -1;
        }
    }

    /*
    *
solution 메서드는 long 타입의 매개변수 n을 받습니다.

if (Math.pow((int)Math.sqrt(n), 2) == n) 부분: 이 부분은 입력된 숫자 n이 어떤 양의 정수의 제곱인지 확인하는 부분입니다.

Math.sqrt(n)는 n의 제곱근을 계산합니다.
(int)Math.sqrt(n)는 제곱근을 정수로 변환합니다. 제곱근이 정수라면 입력된 n은 어떤 양의 정수의 제곱입니다.
Math.pow((int)Math.sqrt(n), 2)는 제곱근을 다시 제곱하여 원래 값과 비교합니다. 이 부분은 입력된 n이 양의 정수의 제곱인지 확인하는 역할을 합니다.
만약 n이 양의 정수의 제곱이라면, 다음 부분이 실행됩니다:

return (long) Math.pow(Math.sqrt(n) + 1, 2);은 n의 제곱근에 1을 더한 후, 그 값을 다시 제곱하여 반환합니다. 이것은 n 다음에 오는 양의 정수의 제곱을 나타냅니다.
만약 n이 양의 정수의 제곱이 아니라면, -1을 반환하여 어떤 값도 반환하지 않습니다.
    * */
}
