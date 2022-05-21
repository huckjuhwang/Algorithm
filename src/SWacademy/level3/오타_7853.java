package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 오타_7853 {
    static String str;
    static int move[] = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            str = br.readLine();
            long sum = 1;

            for (int i = 0; i < str.length(); i++) {
                sum *= getCount(i);
                sum %= 1000000007;
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }

    public static int getCount(int idx) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < move.length; i++) {
            int nx = idx + move[i];
            if (nx < 0 || nx > str.length() - 1) continue;

            if (map.get(str.charAt(nx)) == null)   map.put(str.charAt(nx), 1);
        }
        return map.size();
    }
}
