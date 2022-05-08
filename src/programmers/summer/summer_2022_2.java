package programmers.summer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class summer_2022_2 {
    public static void main(String[] args) {
        String[] solution = solution(new String[]{"[403]James", "[404]Andy,andys,andy", "[101]Azad,Guard"}, 403);
        for (String sol : solution) {
            System.out.println(sol);
        }
    }
    public static String[] solution(String[] rooms, int target) {

        List<Room> list = new ArrayList<>();
        HashMap<String, Room> seat = new HashMap<>();
        // 예외할 직원들
        List<String> exceptionName = new ArrayList<>();

        //["[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"]
        for (String room : rooms) {
            // 방 호수와 이름을 파싱
            int ho = Integer.parseInt( room.substring(1, room.indexOf("]")));
            String names[] = room.substring(room.indexOf("]") + 1).split(",");


            // 해당방에 같은 자리가 있는 직원 제외하기 위한 저장 로직
            if (ho == target){
                for (String name : names)
                    exceptionName.add(name);
                continue;
            }

            // 사람 별 좌석 개수 계산( 중복제거를 위해 Hash 사용 )
            for (String name : names) {
                if (seat.get(name) == null) {
                    seat.put(name, new Room(1, Math.abs(ho-target), name));
                }else{
                    // 거리상으로 작은 값을 넣음
                    int min = seat.get(name).getDistance() < Math.abs(ho - target) ? seat.get(name).getDistance() : Math.abs(ho - target);
                    seat.put(name, new Room(seat.get(name).getSeatCount()+1, min, name));
                }
            }
        }

        // 해당방에 같은 자리가 있는 직원 제외
        for (String name : exceptionName)
            seat.remove(name);

        // 정렬을 위해 List에 삽입
        for (String name : seat.keySet())
            list.add(seat.get(name));

        // 정렬
        Collections.sort(list);
        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i).getName();
        // 리턴
        return result;
    }
}

class Room implements Comparable<Room>{

    private int seatCount;
    private int distance;
    private String name;


    public Room(int seatCount, int distance, String name) {
        this.seatCount = seatCount;
        this.distance = distance;
        this.name = name;
    }


    public int getSeatCount() {
        return seatCount;
    }

    public int getDistance() {
        return distance;
    }


    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Room room) {
        // 좌석 개수별로 정렬
        if (this.seatCount < room.getSeatCount()) {
            return -1;
        } else if (this.seatCount > room.getSeatCount()) {
            return 1;
        }

        // 좌석 개수가 같다면, 거리순으로 정렬
        if (this.distance < room.getDistance())  return -1;
        else if (this.distance > room.getDistance()) return 1;

        int size = this.name.length() > room.name.length() ? room.name.length() : this.name.length();
        // 좌석 개수도 같다면, 이름순으로 정렬
        for (int i = 0; i < size; i++) {
            // 둘다 대문자거나 소문자라면,
            char nowName = this.name.charAt(i);
            char paraName = room.getName().charAt(i);
            //* 대문자 A-Z까지의 범위는 65~90
            //* 소문자 a-z까지의 범위는 97~122
            if (nowName < paraName)  return -1;
            else if (nowName > paraName) return 1;
        }
        return this.name.length() < room.name.length() ? -1 : 1;
    }
}