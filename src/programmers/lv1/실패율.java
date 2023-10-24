package src.programmers.lv1;

import java.util.*;

public class 실패율 {
    class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = {};

            // sort stages
            Arrays.sort(stages);
            int stage = stages[0];
            int failCnt = 0;

            for (int i = 0; i < stages.length; i++) {
                if (stage == stages[i]) {
                    failCnt++;
                } else {
                    stage = stages[i];
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int N, int[] stages) {

            Map<Integer, Double> map = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                double total = 0;
                double fail = 0;
                for (int j = 0; j < stages.length; j++) {
                    if(i <= stages[j]) total++;
                    if(i == stages[j]) fail++;
                }
                if(total == 0 && fail == 0) total = 1;
                map.put(i, fail/total);
            }

            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                double max = -1;
                int rKey = 0;
                for (int key : map.keySet()){
                    if(max < map.get(key)){
                        max = map.get(key);
                        rKey = key;
                    }
                }
                answer[i] = rKey;
                map.remove(rKey);
            }

            return answer;
        }
    }

    class Solution3 {
        public int[] solution(int N, int[] lastStages) {
            int nPlayers = lastStages.length;
            int[] nStagePlayers = new int[N + 2];
            for (int stage : lastStages) {
                nStagePlayers[stage] += 1;
            }

            int remainingPlayers = nPlayers;
            List<Stage> stages = new ArrayList<>();
            for (int id = 1 ; id <= N; id++) {
                double failure = (double) nStagePlayers[id] / remainingPlayers;
                remainingPlayers -= nStagePlayers[id];

                Stage s = new Stage(id, failure);
                stages.add(s);
            }
            Collections.sort(stages, Collections.reverseOrder());

            int[] answer = new int[N];
            for (int i = 0; i < N; i++) {
                answer[i] = stages.get(i).id;
            }
            return answer;
        }

        class Stage implements Comparable<Stage> {
            public int id;
            public double failure;

            public Stage(int id_, double failure_) {
                id = id_;
                failure = failure_;
            }

            @Override
            public int compareTo(Stage o) {
                if (failure < o.failure ) {
                    return -1;
                }
                if (failure > o.failure ) {
                    return 1;
                }
                return 0;
            }
        }
    }

}
