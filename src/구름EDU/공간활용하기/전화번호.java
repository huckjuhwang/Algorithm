package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 전화번호 {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_TABLE_LENGTH = 10000;
    public static int[] table;

    /**
     * data[0] ~ data[n-1]에 등장한 번호들에 대한 빈도수 테이블을 채우는 함수
     * @param data
     * @param n
     * table  table[x] := data배열에서 x가 등장한 횟수
     */
    public static void fillFrequencyTable(int[] data, int n) {
        for(int num : data){
            table[num]++;
        }
    }


    /**
     * data[0] ~ data[n-1]사이에서 가장 많이 등장한 번호를 반환하는 함수
     * @param data
     * @param n
     * @return  가장 많이 등장한 번호. 여러개인 경우 사전순으로 가장 빠른 번호.
     */
    public static int getFrequentNumber(int[] data, int n) {
        table = new int[MAX_TABLE_LENGTH];
        fillFrequencyTable(data, n);
        int max = 0;
        int value = 0;
        Arrays.sort(data);

        for(int i =0; i<n; i++){
            if( table[data[i]] > max ){
                max = table[data[i]];
                value = data[i];
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        int answer = getFrequentNumber(data, n);
        System.out.printf("%04d", answer);
    }
}
