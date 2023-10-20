package src.programmers.lv1;

public class 하샤드수 {
    class Solution {
        public boolean solution(int x) {

            int y = x;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x = x / 10;
            }
            if (y % sum != 0) {
                return false;
            } else {
                return true;
            }

        }
    }

    class Solution2 {
        public boolean solution(int x) {
            int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
            return x % sum == 0;
        }
    }
}
