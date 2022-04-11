package SWacademy.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가위바위보_1936 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");

        // 1 > 3
        // 2 > 1
        // 3 > 2
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);

        // A가 이기는 경우
        if ((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)) {
            System.out.println("A");
        }else{
            System.out.println("B");
        }

    }
}
