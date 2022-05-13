package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_8931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            Stack<Integer> stack = new Stack<>();

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num == 0 && !stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }

            int sum = 0;
            while (!stack.empty()) {
                sum += stack.pop();
            }
            System.out.println("#" + testCase + " " + sum);
        }

    }
}
