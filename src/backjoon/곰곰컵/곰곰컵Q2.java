package backjoon.곰곰컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 곰곰컵Q2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if( str.equals("ENTER"))  {
                map.clear();
                continue;
            }

            // 처음 들어 왔을 경우
            if (map.get(str) == null) {
                count++;
                map.put(str, 1);
            }


        }
        System.out.println(count);
    }
}
