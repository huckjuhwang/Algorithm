package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 삼삼트리플게임_6781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String numbers = br.readLine();
            String color = br.readLine();

            // R,G,B 순 으로 삽입
            int arr[][] = new int[3][10];

            for (int i = 0; i < 9; i++) {
                int num = numbers.charAt(i) - '0';
                char col = color.charAt(i);

                int idx = 0;
                switch (col) {
                    case 'R' : idx = 0; break;
                    case 'G' : idx = 1; break;
                    case 'B' : idx = 2; break;
                }

                arr[idx][num]++;
            }


            boolean check = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 10-2; j++) {

                    // 해당 색깔의 카드가 있을 경우
                    while (arr[i][j] != 0) {
                        // 같은 색깔의 카드가 3장 있을 경우( 해당경우가 최대 임 )
                        if (arr[i][j] % 3 == 0)  {
                            arr[i][j] %= 3;
                            continue;
                        }

                        // 그게 아니라면 한장씩 빼야지.. ( 한장 이상씩 가지고 있는지 체크 )
                        if ( arr[i][j + 1] >= 1
                                         && arr[i][j + 2] >= 1) {
                            arr[i][j]--;
                            arr[i][j + 1]--;
                            arr[i][j + 2]--;
                        }else{
                            // 뺄수 없을 경우 false;
                            check = false;
                        }

                        if( !check) break;
                    }
                }
            }


            if (check) {
                System.out.println("#" + testCase + " "  + "Win");
            }else{
                System.out.println("#" + testCase + " "  + "Continue");
            }
        }

    }
}
