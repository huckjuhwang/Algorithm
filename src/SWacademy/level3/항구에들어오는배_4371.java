package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 항구에들어오는배_4371 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                int diff = Math.abs(arr[i] - arr[i + 1]);
                if (map.get(diff) == null) {
                    map.put(diff, 1);
                }
            }

            System.out.println("#" + testCase + " " + map.size());
        }
    }
}
