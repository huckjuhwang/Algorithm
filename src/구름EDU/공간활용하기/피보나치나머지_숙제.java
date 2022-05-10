package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * A,B,result 3개의 변수로 피보나치 계산 하기.
 * 성능은 비 효율적이지만, 반복문 연습을 위한 예제 학습
 */
public class 피보나치나머지_숙제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 1;
        int b = 1;
        int result = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            result = 0;
            a = 1;
            b = 1;

            // 3이상인 경우
            if( num >= 3 ) {
                for (int j = 3; j <= num; j++) {
                    result = a+b;
                    a = b;
                    b = result;
                }
            }
            // 1이나 2일 경우 결과는 1;
            else if( num == 1 || num== 2 ){
                result = 1;
            }

            System.out.println(result);
        }
    }
}
