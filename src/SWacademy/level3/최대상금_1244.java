package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 *  dfs로 변경
 */
public class 최대상금_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String number = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            int nums[] = new int[number.length()];
            Integer sort[] = new Integer[number.length()];

            for (int i = 0; i < number.length(); i++) {
                nums[i] = Integer.parseInt(number.charAt(i) + "");
            }


            for (int i = 0; i < count; i++) {
                int max = 0;
                int idx = 0;

                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        continue;
                    }else if (nums[j] >= max) {
                        max = nums[j];
                        idx = j;
                    }
                }

                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }

            System.out.print("#" + testCase + " ");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
            }
            System.out.println();
            
        }
    }

    private static int getIDX(int[] nums, int idxVal) {
        int idx = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == idxVal) {
                idx = j;
                break;
            } 
        }
        return idx;
    }
}
