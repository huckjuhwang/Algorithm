package 구름EDU.공간활용하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int arr[][] = new int[101][101];
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                for (int k = x; k < x+10; k++) {
                    for (int l = y; l < y+10; l++) {
                        // 한번도 등장하지 않았을 경우
                        if(arr[k][l] == 0) {
                            arr[k][l]++;
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
