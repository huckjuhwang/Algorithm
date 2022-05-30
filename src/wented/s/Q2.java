package wented.s;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q2 {

    static int arr[][];
    static List<Integer> list;
    static boolean check[];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n + 1][n + 1];
            check = new boolean[n + 1];
            check[0] = true;
            list = new ArrayList<>();

            int depth = 1;

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                // 선수과목 개수,
                int sunsu = Integer.parseInt(st.nextToken());
                if (sunsu == 0) {
                    list.add(i);
                    check[i] = true;
                }
                for (int j = 0; j < sunsu; j++) {
                    arr[i][Integer.parseInt(st.nextToken())]++;
                }
            }

            while (true) {
                // 모든 선수 과목을 마쳤다면, 종료
                if( validCheck() ) break;

                if (depth > n) {
                    depth = -1;
                    break;
                }

                for (int i = 1; i <= n; i++) {
                    // true 인것을 대상으로 순회
                    if (check[i]) {
                        for (int j = 1; j <= n; j++) {
                            if (arr[j][i] == 1) {
                                arr[j][i] = 0;
                            }
                        }
                    }

                }
                for (int j = 1; j <= n; j++) {
                    boolean ch = true;
                    if (!check[j]) {
                        for (int k = 1; k <= n; k++) {
                            if (arr[j][k] == 1) {
                                ch = false;
                            }
                        }
                        check[j] = ch;
                    }
                }
                depth++;


            }


            System.out.println("#" + testCase + " " + depth);


        }
    }

    public static boolean validCheck(){
        for (int i = 1; i <= n; i++) {
            if( !check[i] ) return false;
        }
        return true;
    }
}
