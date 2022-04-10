package SWacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 중간값찾기_2063 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str[] = br.readLine().split(" ");
        int numbers[] = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(numbers);

//        System.out.println(numbers.length/2+1);
        System.out.println( numbers[numbers.length/2] );
    }
}
