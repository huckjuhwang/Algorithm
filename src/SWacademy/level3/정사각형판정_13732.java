package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 정사각형판정_13732 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            char arr[][] = new char[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            boolean check = false;
            int width = 0;
            int start_x = 0;
            int start_y = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (width != 0 && arr[i][j] == '.') {
                        break;
                    }
                    if (arr[i][j] == '#'){
                        width++;
                        if (!check) {
                            start_x = i;
                            start_y = j;
                            check = true;
                        }
                    }
                }
                if(check) break;
            }

            if (width == 1) {
                check = false;
            }else{
                check = true;
            }
            for (int i = start_x; i < start_x + width; i++) {
                for (int j = start_y; j < start_y + width; j++) {
                    if (arr[i][j] != '#')   check = false;
                }
                if( !check) break;
            }

            if (check) {
                System.out.println("#" + testCase + " "+ "yes");
            }else{
                System.out.println("#" + testCase + " "+ "no");
            }
        }
    }
}
