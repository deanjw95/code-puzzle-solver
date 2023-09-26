package src.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 명예의전당1 {

    class Solution {

    }

    class Solution2 {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            List<Integer> sc = new ArrayList<>();
            for (int i=0; i<score.length; i++) {
                sc.add(score[i]);
                sc.sort(Collections.reverseOrder());
                if (i<k-1){
                    answer[i]=sc.get(sc.size()-1);
                } else if (i>=k-1){
                    answer[i]=sc.get(k-1);
                }
            }
            return answer;
        }
    }

    class Solution3 {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            for(int i = 0; i < score.length; i++) {
                priorityQueue.add(score[i]);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }

                answer[i] = priorityQueue.peek();
            }

            return answer;
        }
    }

    /*
    * PriorityQueue 에 대해 익히는 시간
    *
PriorityQueue는 자바에서 제공하는 우선순위 큐 구현체로, 요소들을 우선순위에 따라 처리할 때 사용됩니다. 요소들은 일반적으로 Comparable 또는 Comparator 인터페이스를 구현하여 정의된 우선순위에 따라 처리됩니다.

다음은 PriorityQueue의 주요 특징과 동작 방식에 대한 설명입니다:

우선순위 큐 (Priority Queue):

우선순위 큐는 데이터를 저장하고, 삭제할 때 우선순위에 따라 처리하는 자료구조입니다.
우선순위 큐에서는 항상 가장 높은(또는 낮은) 우선순위를 가진 요소가 먼저 처리됩니다.
내부 구현:

PriorityQueue는 기본적으로 최소 힙(Min Heap) 자료구조를 사용하여 구현됩니다.
최소 힙은 부모 노드가 항상 자식 노드보다 작거나 같은 값을 갖는 이진 트리입니다.
요소 추가 및 삭제:

offer(E e) 또는 add(E e) 메서드를 사용하여 요소를 우선순위 큐에 추가합니다.
poll() 메서드를 사용하여 가장 우선순위가 높은 요소를 제거하고 반환합니다.
peek() 메서드를 사용하여 가장 우선순위가 높은 요소를 제거하지 않고 반환합니다.
우선순위 결정:

요소의 우선순위는 Comparable 또는 Comparator 인터페이스를 구현하여 정의합니다.
요소의 기본 우선순위는 Comparable에서 구현한 순서 또는 Comparator에 따라 결정됩니다.
시간 복잡도:

요소 추가 (offer, add): O(log n)
요소 삭제 (poll): O(log n)
최우선순위 요소 조회 (peek): O(1)
활용:

우선순위 큐는 다양한 알고리즘에서 활용됩니다. 예를 들어, 다익스트라 알고리즘, 힙 정렬 등에서 사용됩니다.
    * */
}
