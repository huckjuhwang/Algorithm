package wented.ka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main2 {


    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 1, 3, 3});
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }


    // O(N)의 시간복잡도를 가짐
    public static int[] solution(int[] arr) {
        // 중복 제거를 위한 hashmap 사용
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        // 한번 등장한 원소만 ArrayList에 삽입
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer strKey : map.keySet()) {
            if (map.get(strKey) == 1){
                arrayList.add(strKey);
            }
        }

        // 결과가 없을 경우 -1 리턴
        // 아닐경우 정렬 후 리턴
        if (arrayList.size() == 0) {
            return new int[]{-1};
        }else{
            int[] result = new int[arrayList.size()];
            int idx = 0;
            for (Integer num : arrayList)
                result[idx++] = num;

            Arrays.sort(result);
            return result;
        }
    }
}
