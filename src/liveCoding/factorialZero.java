package liveCoding;

import java.util.Scanner;

public class factorialZero {


    /**
     * 팩토리얼 0의 개수 구하기
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int zCnt = 0;

        for( int i =1; i<=N; i++){
            if( i%5==0 ){
                zCnt++;
            }
            if( i%25 == 0){
                zCnt++;
            }
        }
        System.out.println("zCnt = " + zCnt);
    }
}
