package backjoon.IM기출대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2304 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;

            start = Math.min(start, L);
            end = Math.max((end), L);
        }

        Stack<Integer> stack = new Stack<>();
        int temp = arr[start];

        for (int i = start+1; i <= end; i++) {
            if (arr[i] < temp) {
                stack.push(i);
            }else{
                while (!stack.isEmpty()) {
                    int p = stack.pop();
                    arr[p] = temp;
                }
                temp = arr[i];
            }
        }
        stack.clear();

        temp = arr[end];
        for (int i = end-1; i >= start; i--) {
            if (arr[i] < temp) {
                stack.push(i);
            }else{
                while (!stack.isEmpty()) {
                    int p = stack.pop();
                    arr[p] = temp;
                }
                temp = arr[i];
            }
        }


        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        System.out.println(sum);

    }
}
