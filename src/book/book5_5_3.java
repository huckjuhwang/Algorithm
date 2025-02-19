package book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class book5_5_3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));

    }

    public static int[] solution(int N, int[] stages) {
        int[] arr = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            arr[stages[i]]++;
        }

        int count = stages.length;

        HashMap<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            count = count - arr[i];

            if(arr[i+1] == 0) {
                map.put(i+1, 0.0);

            } else {
                double failRate = (double) arr[i + 1] /count;
                map.put(i+1, failRate);
            }
        }


        return map.entrySet().stream().sorted((o1, o2) -> Double.compare(o1.getValue(), o2.getValue())).mapToInt(HashMap.Entry::getKey).toArray();

    }
}
