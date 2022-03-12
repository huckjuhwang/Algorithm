package liveCoding;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class binarySearchTree {


    public static void main(String[] args) {
        for (int j = 0; j < 20; j++) {
            System.out.println((int) (Math.random() * 200) - 100);
        }
    }

    public void generateRandomArray(int n) {

        // 배열의 크기를 2*n +1 만큼 생성
        int arr[] = new int[(2*n) +1];
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int j = 0; j < arr.length; ) {
            int num = (int) (Math.random() * 200) - 100;

            if( map.get(num) == null ){
                map.put(num, 0);
                j++;
            }

        }
    }


}
