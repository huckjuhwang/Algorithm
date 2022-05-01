package 동빈나.DFS;

import java.io.IOException;
import java.util.Stack;

public class 괄호변환 {
    static int index;

    public static String solution(String p) {
        if (p.equals("")) return "";
        boolean check = UStringCheck(p);
        String U = p.substring(0, index);
        String V = p.substring(index);

        return check ? U + solution(V) : "(" + solution(V) + ")" + reverse(U);
    }


    /**
     * U가 정상적인 괄호인지 비정상적인 괄호인지
     */
    public static boolean UStringCheck(String p) {
        index = 0;
        int balance = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            index++;
            char ch = p.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                balance++;
            }else{
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                balance--;
            }
            // 괄호가 정상적으로 맞춰진 경우
            if (balance == 0) {
                break;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 균형잡힌 괄호 -> 올바른 괄호로 변환
     * 첫번째 문자와 마지막 문자를 제거
     * 나머지 문자열은 괄호방향으로 뒤집어서 붙임
     */
    public static String reverse(String v) {
        // 양쪽을 전부 짜름
        v = v.substring(1, v.length() - 1);
        StringBuilder sb = new StringBuilder();

        for (char ch : v.toCharArray()) {
            if (ch == '(') {
                sb.append(')');
            }else{
                sb.append('(');
            }
        }
        return sb.toString();
    }


}
