package 동빈나.그리디;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. N에서 1을 뺀다
 * 2. N을 K로 나눈다.
 */
public class 일이될때까지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int count = 0;

        while (N != 1) {
            if (N % K == 0) {
                N /= K;
            }else{
                N--;
            }
            count++;
        }
        System.out.println(count);
    }
}
