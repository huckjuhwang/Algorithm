package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일요일_13229 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String days[] = {"","SAT", "FRI", "THU","WED", "TUE", "MON", "SUN"};

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String now = br.readLine();

            for (int i = 1; i < days.length; i++) {
                if (days[i].equals(now)) {
                    System.out.println("#" + testCase + " " + i);
                }
            }
        }
    }
}
