package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            boolean check = valid(br.readLine());
            if (check) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }

    public static boolean valid(String str) {

        int balance = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                balance++;
            }else{
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                balance--;
            }
            if (balance < 0) {
                break;
            }

        }
        return balance == 0;
    }
}
