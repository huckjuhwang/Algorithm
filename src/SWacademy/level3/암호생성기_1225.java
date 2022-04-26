package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호생성기_1225 {

    static int minus[] = {1, 2, 3, 4, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;
        int size = 8;
        for (int testCase = 1; testCase <= t; testCase++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int nums[] = new int[size];

            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            int startIdx = 0;

            boolean zero = false;
            while (!zero){
                for (int i = 0; i < size; i++) {
                    idx %= 5;
                    nums[i] -= minus[idx++];
                    if (nums[i] <= 0) {
                        nums[i] = 0;
                        startIdx = (i+1)%size;
                        zero= true;
                        break;
                    }
                }

            }

            System.out.print("#" + testCase + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(nums[startIdx++] + " ");
                startIdx %= size;
            }
            System.out.println();
        }
    }
}
