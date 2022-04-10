package SWacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 큰놈_작은놈_같은놈_2070 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String str[] = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            String sign = "";

            if (A > B) {
                sign = ">";
            } else if (A < B) {
                sign = "<";
            }else {
                sign = "=";
            }

            System.out.println("#" + (i+1) + " " + sign);
        }
    }
}
