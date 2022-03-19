package programmers.level1;


import java.util.Locale;

/**
 * 이상한 문자 만들기
 *
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 */
public class strangeWord {

    public static void main(String[] args) {
        String str = solution("try hello  world");

        System.out.println("str = " + str);
    }

    public static String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        String strs[] = s.split("");
        int idx = 0;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(" ")) {
                idx = 0;
                sb.append(" ");
                continue;
            }

            if (idx % 2 == 0) {
                sb.append(strs[i].toUpperCase());
            } else {
                sb.append(strs[i].toLowerCase());
            }
            idx++;

        }
         return sb.toString();
    }
}
