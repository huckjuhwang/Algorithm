package wented.s;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1 {

    static int arr[];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int round = 0;
            while (true) {
                // 정렬 검증
                if (validArr())  break;

                // 짝수 인덱스와 다음 인덱스 비교후 값이 더 크면 변경
                for (int i = 0; i < n-1; i+=2) {
                    if (arr[i] > arr[i + 1]) {
                        swap(i, i+1);
                    }
                }

                // 홀수 인덱스와 다음 인덱스 비교후 값이 더 크면 변경
                for (int i = 1; i < n-1; i+=2) {
                    if (arr[i] > arr[i + 1]) {
                        swap(i, i+1);
                    }
                }

                round++;
            }

            System.out.println("#" + testCase +" " + round);


        }
    }

    public static boolean validArr() {
        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
