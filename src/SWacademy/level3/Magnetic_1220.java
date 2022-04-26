package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Magnetic_1220 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;
        for (int testCase = 1; testCase <= t; testCase++) {

            int size = Integer.parseInt(br.readLine());
            int n[][] = new int[size][size];
            int count = 0;

            // insert
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < size; j++) {
                    n[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < size; i++) {
                boolean NPolar = false;
                boolean SPolar = false;
                
                for (int j = 0; j < size; j++) {
                    if (n[j][i] == 1) {
                        NPolar = true;
                    }else if(NPolar && (n[j][i] == 2)){
                        SPolar = true;
                    }

                    if (NPolar && SPolar) {
                        count++;
                        NPolar = false;
                        SPolar = false;
                    }

                }
            }

            System.out.println("#" + testCase + " " + count);


        }
    }
}
