package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char text = str.charAt(i);
            if (isNumber(text, i)) {
                sum += str.charAt(i) - '0';
            }else if(isAlpha(text)){
                sb.append(str.charAt(i));
            }
        }
        char[] ch = sb.toString().toCharArray();
        Arrays.sort(ch);

        System.out.println(new String(ch) + sum);
    }

    private static boolean isAlpha(char text) {
        return text >= 'A' && text <= 'Z';
    }

    private static boolean isNumber(char ch, int i) {
        return (ch >= '0') && (ch <= '9');
    }
}
