package programmers.greedy;


import java.util.List;
import java.util.Scanner;

/**
 * 상하좌우
 *
 * 입력 조건
 *  - 첫째 줄에 공간의 크기를 나타내는 N이 주어진다
 *  - 둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다
 * 출력 조건
 *  - 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X,Y)를 공백기준으로 구분하여 출력
 */
public class UDLR {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        String router[] = scan.nextLine().split(" ");


        String[] point = {"U", "D", "L", "R"};
        int xCase[] = {-1,1,0,0};
        int yCase[] = {0,0,-1,1};


        int xn = 1;
        int yn = 1;

        int x = 1;
        int y = 1;

        for( String ch : router ){

            for( int i =0; i<point.length; i++ ){
                if ( point[i].equals(ch) ){
                    xn = x + xCase[i];
                    yn = y + yCase[i];
                }
                // 배열을 벗어나는 경우 조치
                if(xn < 1 || yn < 1 || xn > N || yn > N){
                    continue;
                }

                x = xn;
                y = yn;
            }

        }

        System.out.println(x + " " + y );

    }
}
