package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수의새로운연산_1493 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= t; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int pxy[] = new int[2];
            int qxy[] = new int[2];


            int depth =1;
            int value =0;
            int x = 0;
            int y = 0;
            int result = 0;

            // 모든 경우의 수를 돌면서 P와 Q에 대한 xy값을 찾음.
            // 이후 xy값을 더하여
            for (int i = 1; i < 10001; i++) {
                int xIdx = 1;
                int yIdx = depth;
                for (int j = 1; j < depth+1; j++) {
                    value++;
                    if (x == 0 && y == 0) {
                        if (value == p){
                            pxy[0] = xIdx;
                            pxy[1] = yIdx;
                        }
                        if(value == q){
                            qxy[0] = xIdx;
                            qxy[1] = yIdx;
                        }
                    }else{
                        if (xIdx == x && yIdx == y) {
                            result = value;
                            break;
                        }
                    }
                    xIdx++;
                    yIdx--;
                }

                // 종료조건 추가할 것
                if (result != 0) {
                    break;
                }

                // 4개의 값이 있을 경우 값을 더 해 준다.
                if(pxy[0] != 0 && qxy[0] != 0 && pxy[1] != 0 && qxy[1] != 0){
                    x = pxy[0]+qxy[0];
                    y = pxy[1]+qxy[1];
                }

                // depth ++;
                depth++;
            }
            System.out.println("#" + testCase + " " + result);

        }
    }
}
