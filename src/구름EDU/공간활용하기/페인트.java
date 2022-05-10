package 구름EDU.공간활용하기;
import java.io.*;
import java.lang.*;
import java.util.*;


public class 페인트 {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_SEAT_NUMBER = 1000;
    public static final int MAX_COLOR_NUMBER = 100;

    /**
     *
     * @param n : 좌석의 수. 좌석은 0~(n-1)번의 번호를 가진다.
     * @param m : 좌석을 칠한 횟수.
     * @param paintings  : 좌석들을 색칠한 이벤트들의 정보
     */
    public static void solve(int n, int m, Painting[] paintings)
    {
        int[] seats = new int[n]; //seats[i] := i번 좌석의 최종 색상

        int colorCnt[] = new int[MAX_COLOR_NUMBER];


        // 주어진 색칠 정보에 따라서 최종 색칠정보를 시뮬레이션 수행
        // O(N*M)
        for(Painting paint : paintings){
            int start = paint.left;
            int end = paint.right;

            for(int i =start; i<=end; i++){
                seats[i] = paint.color;
            }
        }

        for(int i =0; i<n; i++) colorCnt[seats[i]]++;

        int minColor = -1; //가장 적게 등장한 색상
        int maxColor = -1; //가장 많이 등장한 색상

        for(int i =0; i<MAX_COLOR_NUMBER; i++){
            // 한번도 색칠이 되지 않은 경우 제외
            if( colorCnt[i] == 0) continue;

            // 가장 많이 등장한 색상이 한번도 선택되지 않거나,
            // 현재 CNT보다 다음 CNT가 더 클경우 IDX를 변경
            if( maxColor == -1 || colorCnt[i] > colorCnt[maxColor] )
                maxColor = i;

            // 가장 많이 등장한 색상이 한번도 선택되지 않거나,
            // 현재 CNT보다 다음 CNT가 더 클경우 IDX를 변경
            if( minColor == -1 || colorCnt[i] < colorCnt[minColor])
                minColor = i;
        }


        System.out.println(maxColor);
        System.out.println(minColor);
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //paintings[i] := i번째에 일어난 색칠 이벤트의 정보
        Painting[] paintings = new Painting[m];


        for(int i = 0 ; i < m ; i ++)
        {
            //좌석의 번호는 1번부터 시작하므로, 0 ~ (n-1)범위로 맞추기 위하여 1씩 빼준다
            int left = scanner.nextInt()  -1;
            int right = scanner.nextInt() -1;
            int color = scanner.nextInt();
            paintings[i] = new Painting(left, right, color);
        }

        //문제의 정답을 구한다
        solve(n, m, paintings);
    }

}

//좌석들을 한 번 색칠하는 이벤트에 대한 정보
class Painting{
    public int left;
    public int right;
    public int color;
    Painting(int left, int right, int color)
    {
        this.left = left;
        this.right = right;
        this.color = color;
    }
}