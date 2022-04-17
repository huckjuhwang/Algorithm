package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 스토쿠검증_1974 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int size = 9;

        for (int testCase = 1; testCase <= t; testCase++) {
            boolean check = true;

            String temp[][] = new String[size][size];
            int arr[][] = new int[size][size];
            Map<Integer, Integer> map = new HashMap<>(10);

            // input
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 가로/세로 확인
            for (int i = 0; i < size; i++) {
                int width[] = new int[size];
                int height[] = new int[size];

                for (int j = 0; j < size; j++) {
                    // 개수 계산
                    width[arr[i][j]-1]++;
                    height[arr[j][i]-1]++;
                }

                for (int j = 0; j < size; j++) {
                    if((width[j] != 1) || (height[j] != 1)){
                        check = false;
                    }
                }
            }


            // 사각형 검증
            for (int i = 0; i < size; i+=3) {
                for (int j = 0; j < size; j += 3) {
//                    System.out.print("i = " + i);
//                    System.out.println("   j = " + j);
                    int count[] = new int[size];

                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            count[arr[k][l]-1]++;
                        }
                    }

                    for (int a = 0; a < size; a++) {
                        if (count[a] != 1) {
                            check = false;
                        }
                    }
                }

            }


            if (check) {
                System.out.println("#" + testCase + " " + 1);
            }else {
                System.out.println("#" + testCase + " " + 0);
            }

        }
    }
}
