package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수도요금경쟁_1284 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {

            int A = 0;
            int B = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken());       // A의 1L당 가격
            int Q = Integer.parseInt(st.nextToken());       // B의 기본가격
            int R = Integer.parseInt(st.nextToken());       // B의 기준 가격 넘을때부터 L당 S가격
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());       // 혁주가 낸 수도의 양

            A = P * W;
            B = Q;
            // 초과 했을 경우
            if( W > R)   B += ((W-R) * S);

            System.out.println("#" + testCase + " " + (A<B?A:B));
        }
    }
}
