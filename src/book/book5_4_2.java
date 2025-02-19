package book;

import java.util.Arrays;
import java.util.Collections;

public class book5_4_2 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] arr) {
         Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

         Arrays.sort(result, Collections.reverseOrder());

         return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
