package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class evenOrOdd {

    public static void main(String[] args) {
        solution(new int[]{4, 3, 2, 1});
    }

    public static int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
//        System.out.println("getArrayMin(arr) = " + getArrayMin(arr));
        int min = getArrayMin(arr);

        for (int i = 0; i < list.size(); i++) {
            if( list.get(i) == min){
                list.remove(i);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public static int getArrayMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
