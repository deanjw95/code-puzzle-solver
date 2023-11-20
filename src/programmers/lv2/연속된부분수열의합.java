package src.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연속된부분수열의합 {

    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {0, Integer.MAX_VALUE};

            for (int i = 0; i < sequence.length; i++) {
                int sum = 0;
                int cnt = i;

                while (sum < k && cnt < sequence.length) {
                    System.out.println("i: " + i + ", cnt: " + cnt + ", sum: " + sum);

                    sum += sequence[cnt];

                    if (sum == k && answer[1] - answer[0] > cnt - i) {
                        answer[0] = i;
                        answer[1] = cnt;
                        break;
                    }
                    cnt++;
                }
            }

            System.out.println("answer = " + Arrays.toString(answer));

            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int[] sequence, int k) {
            int left = 0;
            int right = 0;
            int partitionSum = sequence[0]; // 부분 수열의 합

            int n = sequence.length;

            List<SubSequence> subs = new ArrayList<>();
            while (true){
                // 현재 부분 수열의 합과 k가 일치하는 left와 right를 저장함
                if(partitionSum == k){
                    subs.add(new SubSequence(left, right));
                }
                if(left == n && right == n) break;

                if(partitionSum <= k && right < n){
                    right++;
                    // 새로운 원소가 추가되었으므로, right에 위치하는 값을 부분 수열 합에 더함
                    if(right < n) partitionSum += sequence[right];
                } else {
                    // 기존의 left의 위치한 원소를 부분 수열의 합에서 제외
                    if(left < n) partitionSum -= sequence[left];
                    left++;
                }
            }

            // 조건에 가장 일치하는 부분 수열을 맨 앞으로 정렬
            subs.sort(SubSequence::compareTo);

            return new int[]{subs.get(0).left, subs.get(0).right};
        }

        private class SubSequence implements Comparable<SubSequence>{
            int left, right, size;

            public SubSequence(int left, int right) {
                this.left = left;
                this.right = right;
                this.size = right - left;
            }

            @Override
            public int compareTo(SubSequence o) {
                if(this.size == o.size){
                    return this.left - o.left;
                }
                return this.size - o.size;
            }
        }
    }

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;

        Solution solution = new 연속된부분수열의합().new Solution();
        solution.solution(sequence, k);
    }

    /*
이 코드는 주어진 정수 배열 `sequence`에서 합이 `k`인 가장 짧은 부분 수열의 시작 인덱스와 끝 인덱스를 찾는 것으로 보입니다. 코드의 동작을 살펴보겠습니다:

1. `left`와 `right`는 각각 부분 수열의 시작과 끝을 나타내는 인덱스입니다.
2. `partitionSum`은 현재 부분 수열의 합을 나타냅니다. 초기에는 첫 번째 원소로 설정됩니다.
3. `subs`는 합이 `k`인 부분 수열들을 저장하는 리스트입니다.
4. 무한 루프를 시작하며, 현재 부분 수열의 합과 `k`가 일치하는 경우, 해당 부분 수열의 시작과 끝을 `subs` 리스트에 추가합니다.
5. `left`가 배열의 길이와 같고, `right`가 배열의 길이와 같으면 루프를 종료합니다.
6. 현재 부분 수열의 합이 `k`보다 작거나 같고, `right`가 배열의 길이보다 작은 경우에는 `right`를 증가시키고 새로운 원소를 부분 수열의 합에 더합니다.
7. 그렇지 않으면, `left`가 가리키는 원소를 부분 수열의 합에서 빼고, `left`를 증가시킵니다.
8. 부분 수열을 찾을 때마다 `SubSequence` 객체를 생성하여 리스트에 추가하고, 마지막에 리스트를 부분 수열의 크기와 시작 인덱스에 따라 정렬합니다.
9. 가장 짧은 부분 수열을 나타내는 `SubSequence` 객체를 선택하고, 해당 부분 수열의 시작과 끝 인덱스를 반환합니다.

`SubSequence` 클래스는 부분 수열의 시작과 끝, 그리고 부분 수열의 크기를 저장하며, `Comparable` 인터페이스를 구현하여 크기에 따라 오름차순으로 정렬할 수 있도록 합니다.
    * */
}
