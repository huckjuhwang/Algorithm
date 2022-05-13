package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 직사각형길이찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < 3; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (map.get(n) == null) {
                    map.put(n, 1);
                }else{
                    map.put(n, map.get(n)+1);
                }
            }


            for (int key : map.keySet()) {
                int val = map.get(key);
                if (val == 1 || val == 3) {
                    System.out.println("#" + testCase + " " + key);
                }
            }
        }
    }
}
