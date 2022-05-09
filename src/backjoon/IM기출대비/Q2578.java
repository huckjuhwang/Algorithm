package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q2578 {

    static int check[][];
    static int count;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bingo[][] = new int[5][5];
        check = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

//        Arrays.fill(check, 0);

        for (int num : list) {
            idx++;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (bingo[i][j] == num)   check[i][j]++;
                }
            }
            widthCheck();
            lengthCheck();
            leftCheck();
            rightCheck();

            if (count >= 3)   break;
            count = 0;
        }

        System.out.println(idx);
    }

    public static void widthCheck(){
        // 가로 검증
        for (int i = 0; i < 5; i++) {
            int zeroCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (check[i][j] == 0) zeroCnt++;
            }
            if (zeroCnt == 0) count++;
        }
    }

    public static void lengthCheck(){
        // 세로 검증
        for (int i = 0; i < 5; i++) {
            int zeroCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (check[j][i] == 0) zeroCnt++;
            }
            if (zeroCnt == 0) count++;
        }
    }

    public static void leftCheck(){
        int zeroCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i][i] == 0) zeroCnt++;
        }
        if( zeroCnt == 0 ) count++;
    }

    public static void rightCheck(){
        int zeroCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i][5-i-1] == 0) zeroCnt++;
        }
        if( zeroCnt == 0 ) count++;
    }

}
