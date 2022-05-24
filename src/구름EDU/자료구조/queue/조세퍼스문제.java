package 구름EDU.자료구조.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 조세퍼스문제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            Queue<Integer> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                queue.add(i);
            }

            int idx = 1;
            while (!queue.isEmpty()) {
                int p = queue.poll();

                if (idx == M) {
                    sb.append(p).append(" ");
                    idx = 1;
                } else if (idx < M) {
                    queue.add(p);
                    idx++;
                }
            }
            System.out.println(sb);
        }
    }
}
