package src.programmers.lv1;

public class 콜라츠추측 {
    class Solution {
        public int solution(long num) {
            int answer = 0;

            if (num == 1) {
                return 0;
            }

            while (num != 1) {
                if (answer > 500) {
                    return -1;
                }
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = num * 3 + 1;
                }
                answer++;
            }

            return answer;
        }
    }

    class Collatz {
        public int collatz(int num) {
            long n = (long)num;
            for(int i=0; i<500; i++){
                if(n==1) return i;
                n = (n%2==0) ? n/2 : n*3+1;
            }

            return -1;
        }
    }
}
