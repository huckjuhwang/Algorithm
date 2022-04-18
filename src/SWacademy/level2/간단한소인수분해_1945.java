package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한소인수분해_1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int nums[] = {2, 3, 5, 7, 11};


        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            int result[] = new int[5];

            while (n != 1) {
                if (n % nums[idx] == 0) {
                    result[idx]++;
                    n /= nums[idx];
                }else{
                    idx++;
                }
            }

            System.out.print("#" + testCase +" ");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
