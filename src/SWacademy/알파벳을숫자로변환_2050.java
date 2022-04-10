package SWacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳을숫자로변환_2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int n = (int)str.charAt(i);
            System.out.print((n-64) +  " ");

        }
    }
}
