package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class 최고급붕어빵_1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine(), " ");
            boolean tf = true;

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i=0; i<N; i++){
                queue.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < N; i++) {
                System.out.println(queue.poll());
            }


            int beforeTime = 0;
            int cnt=0;

            while(!queue.isEmpty()){
                int enterTime = queue.poll(); //손님 도착 시간
                int newCnt = (enterTime - beforeTime) / M * K; //남은 시간동안 만들수 있는 붕어빵 갯수
                cnt += newCnt;
                beforeTime = beforeTime + (newCnt / K * M);
                if(cnt == 0){
                    tf = false;
                    break;
                }
                cnt -= 1;

            }

            if (tf) {
                System.out.println("#" + testCase + " " + "Possible");
            }else {
                System.out.println("#" + testCase + " " + "Impossible");
            }
        }
    }
}
