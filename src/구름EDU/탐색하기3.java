package 구름EDU;
import java.io.*;
import java.lang.*;
import java.util.*;

public class 탐색하기3 {
    public static final Scanner scanner = new Scanner(System.in);


    /**
     * 평균과의 차가 가장 작은 데이터의 번호를 반환하는 함수
     * 여러 가지라면 가장 빠른 번호를 반환한다.
     *
     * 실수가 나올 경우 최대한 수식을 변형해서 정수로 계산을 할수 있도록 로직을 변경할 것
     *
     * @param data
     * @param n
     * @return int  가장 평균과 가까운 데이터의 번호 (1번부터 시작)
     */
    public static int findIndex(int[] data, int n)
    {
        long sum = 0;
        int x = 0;
        for( int num : data )   sum += num;

        for (int i = 0; i < data.length; i++) {
            int dx = (int) Math.abs((n * data[x]) - sum);       // 여태까지 가장 평균에 가까웠던 값의 거리
            int di = (int) Math.abs((n * data[i]) - sum);       // data[i]와 평균과의 거리

            // dx보다 작다는 이야기는 평균과 같다는 이야기
            if( dx > di )    x = i;
        }


        return x+1;
    }

    public static void main(String[] args)
    {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        int answer = findIndex(data, n);
        int index = answer - 1;
        System.out.printf("%d %d\n", answer, data[index]);
    }

}
