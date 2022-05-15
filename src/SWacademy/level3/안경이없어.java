package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안경이없어 {

    static char ZERO[] = {'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                            'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static char ONE[] = {'A', 'D', 'O', 'P', 'Q', 'R'};
    static char TWO = 'B';

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");

            String A = st.nextToken();
            String B = st.nextToken();

            // 길이가 다를 경우
            if( A.length() != B.length()) {
                sb.append("DIFF");
                System.out.println(sb);
                continue;
            }

            for (int i = 0; i < A.length(); i++) {


                for (char zero : ZERO) {
                    A = A.replace(zero + "", "0");
                    B = B.replace(zero + "", "0");
                }

                for (char one : ONE) {
                    A = A.replace(one + "", "1");
                    B = B.replace(one + "", "1");
                }

                A = A.replace(TWO + "", "2");
                B = B.replace(TWO + "", "2");

            }

            if (A.equals(B)) {
                sb.append("SAME");
            }else{
                sb.append("DIFF");
            }

            System.out.println(sb);
        }
    }
}
