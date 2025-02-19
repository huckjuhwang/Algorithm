package book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class book5_5_1 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {

                int sum = numbers[i] + numbers[j];

                if(!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
