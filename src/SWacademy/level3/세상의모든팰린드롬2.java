package SWacademy.level3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세상의모든팰린드롬2 {

    // 9시 10분 시작
    // 9시 19분 종료
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            String str = br.readLine();
            String reverse = new StringBuilder(str).reverse().toString();
            boolean check = true;

            // *이 있을 경우
            if(str.contains("?")){
                for (int i = 0; i < str.length(); i++) {
                    char str_ch = str.charAt(i);
                    char re_ch = reverse.charAt(i);
                    // * 이 존재할 경우 무시하고 진행
                    if (str_ch == '?' || re_ch == '?')  continue;

                    // 문자열이 다를경우 break후
                    // check false
                    if (str_ch != re_ch) {
                        check = false;
                        break;
                    }
                }
            }else{
                // *이 없을 경우
                // 같지 않다면 false
                if (!str.equals(reverse))  check = false;
            }


            if (check) {
                System.out.println("#" + testCase + " " + "Exist");
            } else {
                System.out.println("#" + testCase + " " + "Not exist");
            }

        }
    }
}
