package SWacademy.level3;

import java.io.IOException;
import java.io.*;
import java.util.StringTokenizer;

public class sum_1209 {

    static int max;
    static int size = 100;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;

        for (int testCase = 1; testCase <= t; testCase++) {
            // 1. input variable
            int forwardDiago = 0;
            int backwardDiago = 0;
            int col[] = new int[size];
            max = 0;
            int temp = Integer.parseInt(br.readLine());

            for(int i =0; i<size; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int row = 0;

                for(int j =0; j<size; j++ ){
                    int n = Integer.parseInt(st.nextToken());
                    row += n;    // 행의 합
                    col[j] += n; // 열의 합


                    if( i== j ) { // 대각 선의 합(정방향)
                        forwardDiago += n;
                    }

                    if (j == (size-i-1)){ // 대각 선의 합(역방향)
                        backwardDiago += n;
                    }

                }
                if( max < row ){
                    max = row;
                }
            }

            if( max < forwardDiago ){
                max = forwardDiago;
            }else if ( max < backwardDiago ){
                max = backwardDiago;
            }

            for( int i = 0; i<size; i++){
                if( max < col[i]){
                    max = col[i];
                }
            }

            // 3. print
            System.out.println("#" + testCase + " " + max);
//			System.out.println("#forwardDiago" + testCase + " " + forwardDiago);
//			System.out.println("#backwardDiago" + testCase + " " + backwardDiago);
        }
    }
}
