package 구름EDU.자료구조.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 폭탄제거순서정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 선행작업의 개수를 저장하는 테이블 ( 해체되어야 하는 노드의 수 )
            int count[] = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(to).add(from);
                count[from]++;
            }

            PriorityQueue<Integer> q = new PriorityQueue<>();
            // 선행작업이 없는데이터를 queue에 삽입
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) {
                    q.add(i);
                }
            }


            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int temp = q.poll();

                sb.append(temp).append(" ");

                ArrayList<Integer> list = graph.get(temp);
                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    // 선행작업 테이블 갱신
                    count[num]--;
                    // 검증
                    if( count[num] == 0 ) {
                        q.add(num);
                    }
                }
            }

            boolean check = true;
            for (int i = 1; i <= n; i++) {
                if (count[i] != 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println(sb);
            }else{
                System.out.println("NO");
            }
        }
    }

}
