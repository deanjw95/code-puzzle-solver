package programmers.lv1;

public class 크기가작은부분문자역 {

    public static void main(String[] args) {
        System.out.println("solu = " + Solution.solution("10203", "15"));
    }

    class Solution {
        public static int solution(String t, String p) {

            Integer answer = 0;
            Long intP = Long.parseLong(p);

            for (int i = 0; i <= t.length() - p.length(); i++) {
                String sub = t.substring(i, i + p.length());
                Long intSub = Long.parseLong(sub);
                if (intSub <= intP) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
