package SWacademy.level3;

import com.sun.jdi.IntegerType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 삼성시의버스노선_6485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int bus_route[] = new int[5001];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                for (int j = from; j <= to; j++) {
                    bus_route[j]++;
                }
            }

            int p = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ");
            for (int num : list) {
                sb.append(bus_route[num]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
