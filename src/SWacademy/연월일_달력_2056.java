package SWacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 연월일_달력_2056 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String date = br.readLine();

            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));

            // month 오류
            if (!(month >= 1 && month <= 12)) {
                System.out.println("#" + (i + 1) + " -1");
                continue;
            }

            boolean dayCheck = true;

            switch (month) {
                // 31일
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (!(day >= 1 && day <= 31)) {
                        dayCheck= false;
                    }
                    break;
                // 30일
                case 4: case 6: case 9: case 11:
                    if (!(day >= 1 && day <= 30)) {
                        dayCheck=false;
                    }
                    break;
                // 28일
                default:
                    if (!(day >= 1 && day <= 28)) {
                        dayCheck=false;
                    }
                    break;
            }
            // 날짜 오류가 없다면
            if (dayCheck) {
                System.out.println("#" + (i + 1) + " "
                        + date.substring(0, 4) + "/"
                        + date.substring(4, 6) + "/"
                        + date.substring(6, 8));
            }else {
                System.out.println("#" + (i + 1) + " -1");
            }
        }
    }
}
