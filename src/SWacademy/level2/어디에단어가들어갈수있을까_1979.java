package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어디에단어가들어갈수있을까_1979 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= test; testCase++) {

            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int word_size = Integer.parseInt(st.nextToken());

            String arr[][] = new String[N][N];

            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().split(" ");
            }

            int oneCount = 0;
            int result =0;
            // 가로 비교
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].equals("1")) {
                        oneCount++;
                    }else{
                        if (oneCount == word_size)
                            result++;
                        oneCount=0;
                    }
                }
                if (oneCount == word_size)
                    result++;
                oneCount = 0;
            }

            // 세로 비교
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[j][i].equals("1")) {
                        oneCount++;
                    }else{
                        if (oneCount == word_size)
                            result++;
                        oneCount=0;
                    }
                }
                if (oneCount == word_size)
                    result++;
                oneCount = 0;
            }

            System.out.println("#" + testCase + " "+  result);

        }
    }
}
