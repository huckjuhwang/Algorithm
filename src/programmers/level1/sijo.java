package programmers.level1;


/**
 * 시저 암호
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 *
 */
public class sijo {


    public static void main(String[] args) {
        String a_b_z = solution("a B z", 4);
        System.out.println("a_b_z = " + a_b_z);
    }


    public static String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if( s.charAt(i) == ' ') {
                sb.append(" ");
                continue;
            }
//   65 90 97 122
            int num = s.charAt(i);
            System.out.println("num = " + num);
            int nextNum = num + n;
            // 91 -> 65
            // 소문자인 경우
            if ( num >= 65 && num <= 90) {
                if( nextNum > 90 ){
                    nextNum -= 26;
                }
            }else { // 대문자인 경우
                if (nextNum > 122) {
                    nextNum -= 26;
                }
            }
            sb.append((char)nextNum);
        }

        return sb.toString();
    }
}
