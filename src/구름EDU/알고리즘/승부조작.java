package 구름EDU.알고리즘;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 승부조작 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 게임의 규칙에 따라 현무가 승리할 수 있는 경우의 수가 존재하는지 검사하는 함수
     *
     * @param data
     * @param n
     * @param k
     * @return true   현무가 승리할 수 있는 경우의 수가 하나 이상 존재한다면(짝수)
     * @return false  else
     */
    public static boolean isWinnable(int[] data, int n, int k) {

        int winCount = 0;

        int sum =0;
        for( int i =0; i<k; i++ ){
            sum += data[i];
        }

        for(int i =1; i<n-k+1; i++){
            sum = sum - data[i-1] + data[i+k-1];
            if( sum%2== 0 )	return true;

        }
        return false;

    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        boolean result = isWinnable(data, n, k);

        if(result)
        {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

}
