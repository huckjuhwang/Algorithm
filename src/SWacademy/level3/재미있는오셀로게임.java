package SWacademy.level3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재미있는오셀로게임 {
    static int black = 1;
    static int white = 2;
    static int arr[][];
    static int N;

    // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};    // 상하
    static int[] dy = {-1,  0,  1,-1 ,1,-1, 0, 1};   // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 배열의 크기
            N = Integer.parseInt(st.nextToken());
            // 돌을 놓는 횟수
            int M = Integer.parseInt(st.nextToken());
            // 배열 초기화
            initArr();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                // 입력 값 세팅
                arr[x][y] = color;
                othello(x, y, color);
            }
            resultPrint(testCase);
        }
    }

    private static void initArr() {
        arr = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = -1;
            }
        }
        // white
        arr[N / 2][N / 2] = white;
        arr[(N / 2) + 1][(N / 2) + 1] = white;
        // black
        arr[(N / 2) + 1][(N / 2)] = black;
        arr[(N / 2)][(N / 2) + 1] = black;
    }

    /**
     * 핵심 비지니스 로직
     */
    public static void othello(int x, int y, int nowColor) {

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 배열의 범위를 벗어나지 않고,
            if (rangeOverflow(nextX, nextY)) {
                // 주위에 다른 색깔이 존재한다면
                if( arr[nextX][nextY] == (3-nowColor) ){

                    while (arr[nextX][nextY] != (3 - nowColor)) {
                        // 같은 색깔의 위치를 찾음
                        int target[] = findTarget(x, y, nextX, nextY, i);
                        // 바둑알을 뒤집음.
                        if (target != null) {
                            changeStone(x, y, target[0], target[1], i);
                        }
                    }
                }
            }
        }

    }


    /**
     * 목표 인덱스까지 이동 하며, stone 변경
     */
    private static void changeStone(int x, int y, int tx, int ty, int idx) {
        int chgStone = arr[x][y];

        switch (idx) {
            case 0:  // 좌상
                while ( (--x != tx) && (--y != ty))    arr[x][y] = chgStone;
                break;
            case 1:  // 상
                while ( (--x != tx) )   arr[x][y] = chgStone;
                break;
            case 2:  // 우상
                while ( (--x != tx) && (++y != ty))  arr[x][y] = chgStone;
                break;
            case 3:  // 좌
                while ( (--y != ty))   arr[x][y] = chgStone;
                break;
            case 4:  // 우
                while ( (++y != ty))   arr[x][y] = chgStone;
                break;
            case 5:  // 좌하
                while ( (++x != tx) && (--y != ty))  arr[x][y] = chgStone;
                break;
            case 6:  // 하
                while ( (++x != tx) )  arr[x][y] = chgStone;
                break;
            case 7:  // 우하
                while ( (++x != tx) && (++y != ty))   arr[x][y] = chgStone;
                break;
        }
    }

    /**
     * 같은 색깔이 존재하는 위치를 찾는 메서드
     */
    private static int[] findTarget(int x, int y, int nextX, int nextY, int idx) {

        // 좌상, 상, 우상, 좌, 우, 좌하, 하, 우하
        switch (idx) {
            case 0:  // 좌상
                while (arr[nextX--][nextY--] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX + 1, nextY + 1};
            case 1:  // 상
                while (arr[nextX--][nextY] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX + 1, nextY};
            case 2:  // 우상
                while (arr[nextX--][nextY++] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX + 1, nextY -1};
            case 3:  // 좌
                while (arr[nextX][nextY--] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX, nextY+1};
            case 4:  // 우
                while (arr[nextX][nextY++] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX, nextY-1};
            case 5:  // 좌하
                while (arr[nextX++][nextY--] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX-1, nextY+1};
            case 6:  // 하
                while (arr[nextX++][nextY] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX-1, nextY};
            case 7:  // 우하
                while (arr[nextX++][nextY++] != arr[x][y]) {
                    if (!rangeOverflow(nextX, nextY))  return null;
                }
                return new int[]{nextX-1, nextY-1};
        }
        return null;
    }

    /**
     * 범위를 벗 어날 경우 false
     * 범위 안에 있을 경우 true
     */
    private static boolean rangeOverflow(int nextX, int nextY) {
        return arr[nextX][nextY] != 0 ;
    }

    /**
     * 출력 메소드
     */
    private static void resultPrint(int testCase) {
        int blackCnt = 0;
        int whiteCnt = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
//                System.out.print(arr[i][j] + " ");
                if( arr[i][j] == white ){
                    whiteCnt++;
                } else if (arr[i][j] == black) {
                    blackCnt++;
                }
            }
//            System.out.println();
        }
        System.out.println("#" + testCase + " " + blackCnt + " " + whiteCnt);
    }
}
