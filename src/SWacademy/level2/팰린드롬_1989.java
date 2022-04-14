package SWacademy.level2;

import org.codehaus.groovy.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬_1989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= n; testCase++) {
            String str = br.readLine();
            System.out.println("#" + testCase + " "
                    + (str.equals(new StringBuilder(str).reverse().toString()) ? "1" : "0"));

        }
    }
}
