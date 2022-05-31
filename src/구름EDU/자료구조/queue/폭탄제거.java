package 구름EDU.자료구조.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 폭탄제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            // 선행작업이 존재하는지 유무
            int count[] = new int[N + 1];

            for (int i = 0; i <= N; i++)
                graph.add(new ArrayList<>());

            // 선행작업에 대한 테이블을 계산해준다
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(to).add(from);
                count[from]++;
            }

            // 선행작없이 없는 노드를 큐에 넣어준다.
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (count[i] == 0) q.add(i);
            }

            while (!q.isEmpty()) {
                int temp = q.poll();
                ArrayList<Integer> list = graph.get(temp);

                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    // 테이블 갱신
                    count[num]--;
                    // 0인테이블 조회 후 큐에 넣어줌
                    if (count[num] == 0) {
                        q.add(num);
                    }
                }
            }


            boolean check = true;
            for (int i = 1; i <= N; i++) {
                if (count[i] != 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }



        }
    }
}
