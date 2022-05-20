package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 문자열교집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;
            HashMap<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                String str = st.nextToken();
                if (map.get(str) == null) {
                    map.put(str, 1);
                }else{
                    count++;
                }
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                String str = st.nextToken();
                if (map.get(str) == null) {
                    map.put(str, 1);
                }else{
                    count++;
                }
            }

            System.out.println("#" + testCase + " " + count);


        }
    }
}
