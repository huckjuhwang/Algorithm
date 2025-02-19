import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'entryTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s  423692
     *  2. STRING keypad  953857614
     */

    // 동, 서, 남, 북,북동, 북서, 남서, 남동
    static int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
    static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};

    public static int entryTime(String s, String keypad) {
        int[][] keypadArr = new int[3][3];

        int result = 0;
        for (int i = 0; i < keypad.length(); i++) {
            int number = keypad.charAt(i) - '0';

            if(i == 0) {
                keypadArr[0][0] = number;
            } else {
                keypadArr[i/3][i%3] = number;
            }
        }



        for (int i = 1; i < s.length(); i++) {
            int target = s.charAt(i) - '0';
            int startNumber = s.charAt(i-1) - '0';
            int[] startPosition = getStartPosition(keypadArr, startNumber);

            int[][] visit = new int[3][3];

            result += bfs(target, visit, keypadArr, startPosition);
        }


        return result;

    }

    public static int[] getStartPosition(int[][] keypadArr, int number) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(keypadArr[i][j] == number){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }


    public static int bfs(int target, int[][] visit, int[][] keypadArr, int[] startPosition) {
        Queue<int[]> q = new LinkedList<>();
        q.add(startPosition);

        int x = startPosition[0];
        int y = startPosition[1];
        visit[x][y] = 1;

        if(keypadArr[x][y] == target) {
            return 0;
        }


        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int nowX = temp[0];
            int nowY = temp[1];

            for(int i=0; i<dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 범위 오버 체크
                if(nextX < 0 || nextX >= 3 || nextY < 0 || nextY >= 3) {
                    continue;
                }

                if(visit[nextX][nextY] == 0) {
                    visit[nextX][nextY] = visit[nowX][nowY] + 1;

                    // 타겟을 찾으면 리턴
                    if(keypadArr[nextX][nextY] == target){
                        return visit[nextX][nextY] -1;
                    }

                    q.add(new int[]{nextX, nextY});
                }


            }
        }

        return -1;
    }


}
