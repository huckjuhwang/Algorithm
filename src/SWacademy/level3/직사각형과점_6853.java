package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형과점_6853 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());

            int innerCnt = 0;
            int outCnt = 0;
            int pointCnt = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int point_x = Integer.parseInt(st.nextToken());
                int point_y = Integer.parseInt(st.nextToken());

                if ((x1 < point_x && x2 > point_x) && (y1 < point_y && y2 > point_y)) {
                    innerCnt++;
                } else if ((x1 > point_x || x2 < point_x) || (y1 > point_y || y2 < point_y)) {
                    outCnt++;
                }else{
                    pointCnt++;
                }
            }

            System.out.println("#" + testCase + " " +  innerCnt +" " + pointCnt + " " + outCnt) ;

        }
    }
}
