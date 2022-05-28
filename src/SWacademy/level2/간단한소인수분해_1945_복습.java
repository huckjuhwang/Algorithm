package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;


public class 간단한소인수분해_1945_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int nums[] = {2, 3, 5, 7, 11};

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                while (n % nums[i] == 0) {
                    count++;
                    n /= nums[i];
                }
                list.add(count);
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testCase);
            for (int num : list) {
                sb.append(" ").append(num);
            }

            System.out.println(sb);

        }
    }
}
