package 구름EDU.알고리즘;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 픽셀수세기 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽 아래 좌표가 (x,y)인 픽셀이 반지름 R인 원에 포함되는가?
     * @param x
     * @param y
     * @param R
     * @return  포함된다면 true, else false
     */
    public static boolean isInside(long x, long y, long R)
    {
        long sqd = x*x + y*y;
        return sqd < R*R;
    }

    public static void testCase(int caseIndex) {
        long R = scanner.nextLong();
        long count = 0;
        long j=R;

        for(int i=0; i<R; i++){
            for( ; j>=0; j--){
                if( isInside(i,j,R) ){
                    long h = (j+1);
                    count += h;
                    break;
                }
            }
        }


        System.out.printf("#%d\n", caseIndex);
        System.out.println(count*4);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

}
