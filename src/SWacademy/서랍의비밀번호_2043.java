package SWacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 서랍의비밀번호_2043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        int numbers[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }

        System.out.println(numbers[0] - numbers[1] + 1);
    }
}
