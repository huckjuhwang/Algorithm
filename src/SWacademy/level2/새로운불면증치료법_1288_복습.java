package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 새로운불면증치료법_1288_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<Character, Integer> map = new HashMap<>();
            int idx = 1;

            while (true) {
                String nx = Integer.toString(n * idx);
                for (int i = 0; i < nx.length(); i++) {
                    char c = nx.charAt(i);
                    if (map.get(c) == null) map.put(c, 1);
                }
                if (map.size() == 10)   break;
                idx++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase).append(" ").append(idx * n);
            System.out.println(sb);
        }
    }
}
