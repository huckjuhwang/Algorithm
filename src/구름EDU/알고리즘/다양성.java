package 구름EDU.알고리즘;

import java.io.*;
import java.lang.*;
import java.util.*;

public class 다양성 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 중복을 제외한 숫자의 종류의 수를 계산하는 함수
     * @param data  원본 배열
     * @param n     원본 배열의 크기
     * @return  숫자의 종류의 수
     */
    public static int getElementTypeCount(int[] data, int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : data) {
            if (map.get(num) == null)    map.put(num, 1);
        }

        return map.size();
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        int answer= getElementTypeCount(data, n);

        System.out.println(answer);

    }

}
