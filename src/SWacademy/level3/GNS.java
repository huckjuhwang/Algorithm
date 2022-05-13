package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GNS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String NUMBER[] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        for (int testCase = 1; testCase <= t; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");


            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = st.nextToken();
                for (int j = 0; j < 10; j++) {
                    if (str.equals(NUMBER[j])) {
                        list.add(j);
                    }
                }
            }

            Collections.sort(list);


            sb.append("#").append(testCase).append(" ");
            for (int num : list)    sb.append(NUMBER[num]).append(" ");
            System.out.println(sb);
        }
    }
}
