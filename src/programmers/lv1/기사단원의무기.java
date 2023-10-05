package src.programmers.lv1;

public class 기사단원의무기 {

    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;

            // number의 약수 개수 구하기
            for(int i=1; i<=number; i++){
                int cnt = get약수(i);

                // 약수의 개수가 limit보다 크면 answer+= power, 아니면 answer+= 약수의 개수
                answer += cnt > limit ? power : cnt;

            }

            // 약수 구하는 다른 방법

            return answer;
        }
    }

    private static int get약수(int 기사) {
        int cnt = 0;

        for (int j = 1; j <= 기사; j++) {
            if(기사 % j == 0){
                cnt++;
            }
        }
        return cnt;
    }

    class Solution2 {
        public int solution(int number, int limit, int power) {
            int answer = 0;

            for(int i=1;i<=number;i++){
                int cnt = 0;
                for(int j=1;j*j<=i;j++){
                    if(j*j==i) cnt++;
                    else if(i%j==0) cnt+=2;
                }

                if(cnt>limit) cnt = power;
                answer += cnt;
            }

            return answer;
        }
    }

    /*
약수를 찾는 과정에서 1부터 해당 수의 제곱근까지만 반복하는 이유는, 약수는 대칭적인 특성을 갖기 때문입니다. 즉, 어떤 수의 약수를 찾을 때, 그 수의 제곱근을 기준으로 작은 약수와 큰 약수가 짝을 이룹니다.

약수의 특성:

어떤 수의 약수는 대칭적입니다. 예를 들어, 수 20의 약수를 구한다고 가정해봅시다. 수 20의 약수는 (1, 20), (2, 10), (4, 5)와 같이 대칭적으로 나타납니다. 이 중에서 작은 약수인 1, 2, 4는 수 20의 제곱근(약수 중 가운데에 위치)인 4.47보다 작거나 같습니다.
반복 범위 제한:

따라서, 약수를 찾을 때 1부터 해당 수의 제곱근까지만 반복하여 찾는 것이 효율적입니다. 제곱근 이상의 약수는 이미 이전에 제곱근 이하의 약수를 찾으면서 계산했기 때문에 중복 계산을 피할 수 있습니다.
예시를 통해 설명하겠습니다. 수 20의 약수를 찾는 경우:

1부터 4까지 반복하면서, 20을 나눌 수 있는 약수를 찾습니다.
1은 20의 약수이며, 20을 1로 나눈 결과는 20입니다.
2는 20의 약수이며, 20을 2로 나눈 결과는 10입니다.
3은 20의 약수가 아니므로 넘어갑니다.
4는 20의 약수이며, 20을 4로 나눈 결과는 5입니다.
따라서, 1부터 4까지만 반복하여 약수를 찾아도 모든 약수를 찾을 수 있으며, 중복 계산을 피할 수 있습니다.
    * */

}
