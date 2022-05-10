package 구름EDU.알고리즘;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 정주행 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 배열의 N개의 원소가 연속적인 정수 수열로 표현될 수 있는지 판단하는 함수
     * @param data
     * @param n
     * @return
     */
    public static boolean isConsecutive(int[] data, int n)
    {

        int min = Integer.MAX_VALUE;
        int max = -1;

        for( int i=0; i<n; i++){
            if( min > data[i] ) min = data[i];
            if( max < data[i] ) max = data[i];
        }

        return max-min+1 == n;


// 		Arrays.sort(data);

// 		for(int i =0; i<n-1; i++){
// 			if( data[i] != data[i+1]-1) return false;
// 		}
// 		return true;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i ++)
        {
            data[i] = scanner.nextInt();
        }

        boolean result = isConsecutive(data, n);

        if(result)
        {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
