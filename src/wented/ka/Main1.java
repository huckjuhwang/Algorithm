package wented.ka;

import java.util.Locale;

public class Main1 {

    public static void main(String[] args) {
        String solution = solution("Jackdaws love my big sphinx of quartz");
        System.out.println(solution);
    }


    // 계수정렬 알고리즘을 사용하여 해결 할 예정
    // 뮨장의 길이를 N이라고 했을때, O(N)의 시간복잡도가 소요된다.
    public static String solution(String sentence) {

        int alpha[] = new int[26];
        // 소문자로 변환 및 공백 제거
        sentence = sentence.toLowerCase(Locale.ROOT);

        for (int i = 0; i < sentence.length(); i++) {
            int num = sentence.charAt(i)-'a';
            // 소문자 범위내에 있다면( 다른 특수문자가 나올 경우를 대비하여, 방어로직 개선 )
            if (num >= 0 && num <= 25) {
                alpha[num]++;
            }
        }


        // 문자열 연산시에 append연산으로 성능 향상
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alpha.length; i++) {
            // 한번도 등장하지 않았다면,
            if (alpha[i] == 0) {
                sb.append((char)(i + 'a'));
            }
        }

        return sb.length() == 0 ? "perfect" : sb.toString();
    }
}
