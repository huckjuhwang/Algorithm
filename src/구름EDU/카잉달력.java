package 구름EDU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 카잉달력 {

    static int M, N;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            List<Integer> result = new ArrayList<>();

            for (int index = x; index <= N*M; index+= M) {
                if (y == getYbyIndex(index)) {
                    result.add(index);
                    break;
                }
            }

            // 값이 존재 한다면,
            if (!result.isEmpty()) {
                System.out.println(result.get(0));
            }else{
                System.out.println(-1);
            }

        }
    }


    public static int getXbyIndex(int index) {
        return (index - 1) % M + 1;
    }
    public static int getYbyIndex(int index) {
        return (index - 1) % N + 1;
    }

}
