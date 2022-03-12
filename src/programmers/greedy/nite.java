package programmers.greedy;

import java.util.Scanner;


/**
 * 8*8 장기판에서
 * 특정 위치가 주어졌을때 마가 이동할 수 있는 장소는 몇개가 있는가??
 *
 * 입력 조건
 *  - 행은 1~8, 열은 a~h까지로
 *    첫번째 칸의 경우 a1로 주어진다.
 */
public class nite {

    public static final int MIN = 1;
    public static final int MAX = 8;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int cnt = 0;

        int nowX = text.charAt(0) - 'a' + 1;
        int nowY = text.charAt(1) - '0';

        int tempX;
        int tempY;


        String[] move = {"3RU", "3RD", "3LU", "3LD", "3DR", "3DL", "3UR", "3UL"};
        int xCnt[] = {-1, 1, -1, 1, 3, 3, -3, -3};
        int yCnt[] = {3,3,-3,-3,1,-1,1,-1};

        int idx = 0;
        for( String m : move ){

            tempX = nowX + xCnt[idx];
            tempY = nowY + yCnt[idx];
            idx++;

            // 넘어가는 제어조건 97 <= X <= 104 // 1 <= y <= 8
            if( tempX > MAX || tempX < MIN || tempY < MIN || tempY > MAX){
                continue;
            }
            cnt++;
        }

        System.out.println("cnt = " + cnt);

    }
}
