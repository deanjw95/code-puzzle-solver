package src.programmers.lv1;

public class 일차비밀지도 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                int temp = arr1[i] | arr2[i];
                while (temp > 0) {
                    if (temp % 2 == 1) {
                        sb.append("#");
                    } else {
                        sb.append(" ");
                    }
                    temp /= 2;
                }
                if (sb.length() < n) {
                    while (sb.length() < n) {
                        sb.append(" ");
                    }
                }
                answer[i] = sb.reverse().toString();
            }

            return answer;
        }
    }

    class Solution2 {
        public String makeSharp(int n, int m) {
            if(n == 0) {
                if( m > 0) {
                    String str = "";
                    for(int i = 0; i < m; i++) {
                        str += " ";
                    }
                    return str;
                }
                else return "";
            }
            else {
                return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#";
            }
        }
        public String[] solution(int n, int [] arr1, int [] arr2) {
            String [] answer = new String[n];
            int [] secretMap = new int[n];
            for(int i = 0; i < n; i++) {
                secretMap[i] = arr1[i] | arr2[i];
                answer[i] = makeSharp(secretMap[i], n);
            }
            return answer;
        }
    }

    /*
주어진 코드는 두 개의 정수 배열 arr1과 arr2로부터 "비밀 지도"를 생성하는 Java 클래스 Solution2를 정의하고 있습니다. 이 클래스에는 solution 메서드와 makeSharp 메서드가 있습니다.

makeSharp 메서드는 n과 m이라는 두 개의 정수 매개변수를 받습니다. 이 메서드의 목적은 n과 m을 기반으로 공백과 # 문자로 이루어진 문자열을 생성하는 것입니다.
이 메서드는 재귀적으로 호출되며, 다음과 같은 동작을 수행합니다:

만약 n이 0이라면, m이 양수인 경우 공백 문자열을 반환합니다. m이 0이라면 빈 문자열을 반환합니다.
그렇지 않은 경우, n이 짝수인지 여부를 확인하고 n/2와 m-1을 사용하여 재귀적으로 makeSharp 메서드를 호출한 후, 결과 문자열의 끝에 공백 또는 # 문자를 추가하여 반환합니다.
solution 메서드는 n, arr1, 및 arr2를 입력으로 받고, n 크기의 문자열 배열인 answer를 생성하고 초기화합니다.
그런 다음, arr1과 arr2 배열의 각 요소에 대해 Bitwise OR (|) 연산을 수행하여 secretMap 배열에 저장하고, 해당 값과 n을 makeSharp 메서드로 전달하여 answer 배열을 채웁니다.

최종적으로, answer 배열에는 arr1과 arr2의 요소를 비트별 OR 연산하여 생성된 비밀 지도의 각 줄이 저장되며, answer 배열이 반환됩니다.

이 코드는 두 개의 이진 배열로부터 비밀 지도를 생성하는 간단한 예제로, 각 비트의 상태에 따라 공백 또는 벽 (#)을 표현하는 방식입니다.
    * */
}
