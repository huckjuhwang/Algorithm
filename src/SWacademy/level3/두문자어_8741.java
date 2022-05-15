package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class 두문자어_8741 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < 3; i++) {
                char ch = st.nextToken().toUpperCase(Locale.ROOT).charAt(0);
                sb.append(ch);
            }

            System.out.println(sb);
        }
    }
}
