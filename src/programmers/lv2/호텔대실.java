package src.programmers.lv2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 호텔대실 {
    class Solution {
        public int solution(String[][] book_time) {
            int answer = 0;
            Room[] rooms = new Room[book_time.length];
            List<Room> roomList = new ArrayList<>();

            for (int i = 0; i < book_time.length; i++) {
                String[] split = book_time[i];
                rooms[i] = new Room(LocalTime.parse(split[0]), LocalTime.parse(split[1]).plusMinutes(9));
            }

            Arrays.sort(rooms, (o1, o2) -> {
                if (o1.start.equals(o2.start)) {
                    return o1.end.compareTo(o2.end);
                }
                return o1.start.compareTo(o2.start);
            });

            for (int i = 0; i < rooms.length; i++) {
                // filter ended rooms
                Room room = rooms[i];
                roomList.add(room);
                roomList.removeIf(r -> r.end.isBefore(room.start));

                answer = Math.max(answer, roomList.size());
                System.out.println("room = " + room + ", roomList = " + roomList.size());
            }

            return answer;
        }

        class Room {
            LocalTime start;
            LocalTime end;

            public Room(LocalTime start, LocalTime end) {
                this.start = start;
                this.end = end;
            }
        }
    }

    class Solution2 {
        private static final int MAX_TIME = 1_450; // 24*60 + 10;
        private static final int HOUR = 60;
        private static final int CLEAN_TIME = 10; // 청소시간

        public static int solution(String[][] book_time) {
            int answer = 0;

            int[] rooms = new int[MAX_TIME];

            for (String[] time : book_time) {
                String inTime = time[0];
                String outTime = time[1];

                rooms[calTime(inTime)] += 1; // 입실 시간
            /*
              끝+1을 하지 않는 것은 seeminglyjs님의 질문에 대한 댓글을 참고해 주세요!
            */
                rooms[calTime(outTime) + CLEAN_TIME] += -1; // 퇴실 + 청소 시간
            }

            // 누적합
            for (int i = 1; i < MAX_TIME; i++) {
                rooms[i] += rooms[i-1];
                answer = Math.max(answer, rooms[i]);
            }

            return answer;
        }

        private static int calTime(String time){
            String[] split = time.split(":");
            String hour = split[0];
            String minute = split[1];
            return ((Integer.parseInt(hour) * HOUR) + Integer.parseInt(minute));
        }
    }






    /*
     * */
}
