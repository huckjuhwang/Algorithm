package programmers.level1;

import java.util.*;
import java.time.LocalDate;

public class deletionOfPersonalInformation {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();

        Map<String, String> map = new HashMap<>();

        for(String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], temp[1]);
        }

        int count = 1;

        for(String privacie : privacies){

            String[] temp = privacie.split(" ");

            String expireTime = map.get(temp[1]);

            LocalDate endDate = toLocalDate(temp[0], expireTime);
            LocalDate startDate = toLocalDate(today);

            if(!endDate.isAfter(startDate)) {
                result.add(count);
            }

            count++;

        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    private static LocalDate toLocalDate(String time) {
        String[] temp = time.split("\\.");

        return LocalDate.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
    }

    private static LocalDate toLocalDate(String time, String plusMonth) {
        String[] temp = time.split("\\.");

        return LocalDate.of(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])).plusMonths(Integer.parseInt(plusMonth));
    }
}
