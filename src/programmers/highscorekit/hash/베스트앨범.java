package src.programmers.highscorekit.hash;

import java.util.*;

public class 베스트앨범 {
    class Solution {
        public int[] solution(String[] genres, int[] plays) {

            Map<String, PriorityQueue<Song>> map = new HashMap<>();
            Map<String, Integer> genrePlay = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if (!map.containsKey(genres[i])) {
                    map.put(genres[i], new PriorityQueue<>((o1, o2) -> {
                        if (o1.getPlay() == o2.getPlay()) {
                            return o1.getIndex() - o2.getIndex();
                        }
                        return o2.getPlay() - o1.getPlay();
                    }));

                    genrePlay.put(genres[i], 0);
                }

                map.get(genres[i]).add(new Song(genres[i], plays[i], i));
                genrePlay.put(genres[i], genrePlay.get(genres[i]) + plays[i]);
            }

            // genrePlay에서 가장 많이 재생된 장르 순으로 정렬
            PriorityQueue<String> genrePlaySort = new PriorityQueue<>((o1, o2) -> genrePlay.get(o2) - genrePlay.get(o1));
            genrePlaySort.addAll(genrePlay.keySet());

            List<Integer> answerList = new ArrayList<>();

            // 장르별로 가장 많이 재생된 노래 2개씩 answer에 담기
            for (int i = 0; i < map.keySet().size(); i++) {
                String genre = genrePlaySort.poll();
                for (int j = 0; j < 2; j++) {
                    if (map.get(genre).isEmpty()) {
                        break;
                    }

                    answerList.add(map.get(genre).poll().getIndex());
                }
            }
            return answerList.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class Song {
        private String genre;
        private int play;
        private int index;

        public Song(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        public int getIndex() {
            return index;
        }
    }


    /*
     * */
}
