package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정사각형판정_13732 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            char arr[][] = new char[n][n];
            boolean check = true;

            int sX = 0;
            int sY = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '#') {
                        if (count==0) { // 시작값을 넣어준다.
                            sX=i;
                            sY=j;
                        }
                        count++;
                    }
                }
            }


            for (int i = sX; i < sX + Math.sqrt(count); i++) {
                for (int j = sY; j < sY + Math.sqrt(count); j++) {
                    // (i,j 범위 초과) OR (#이 없는경우) 체크
                    if (i < 0 || j < 0 || i >= n || j >= n || arr[i][j] != '#') {
                        check = false;
                        break;
                    }
                }

                // 단 하나라도 #이 없으면, 조건에 부합하지 않으므로 break
                if( !check ) break;
            }

            if (check) {
                System.out.println("#" + testCase + " "+ "yes");
            }else{
                System.out.println("#" + testCase + " "+ "no");
            }
        }
    }
}
