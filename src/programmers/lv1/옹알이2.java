package src.programmers.lv1;

public class 옹알이2 {

    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] 발음들 = {"aya", "ye", "woo", "ma"};

            for (int i = 0; i < babbling.length; i++) {
                // babbling[i]에 발음들이 불포함될때까지 제거
                while (true) {
                    boolean isContain = false;

                    for (String 발음 : 발음들) {
                        if (babbling[i].contains(발음)) {
                            if (babbling[i].contains(발음 + 발음)) {
                                break;
                            }
                            babbling[i] = babbling[i].replace(발음, ".");
                            isContain = true;
                        }
                    }
                    if (!isContain) {
                        break;
                    }
                }
                // babbling[i]에 .만 있으면 answer++
                if (babbling[i].matches("[.]+")) {
                    answer++;
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(String[] babblings) {
            // "aya", "ye", "woo", "ma" 4가지 발음만 가능
            int answer = 0;
            for(int i = 0; i < babblings.length; i++) {
                if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                    continue;
                }

                babblings[i] = babblings[i].replace("aya", " ");
                babblings[i] = babblings[i].replace("ye", " ");
                babblings[i] = babblings[i].replace("woo", " ");
                babblings[i] = babblings[i].replace("ma", " ");
                babblings[i] = babblings[i].replace(" ", "");

                if(babblings[i].length()  == 0) answer++;

            }
            return answer;
        }
    }
}
