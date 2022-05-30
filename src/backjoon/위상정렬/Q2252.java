package backjoon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   // 학생의 수
        int m = Integer.parseInt(st.nextToken());   // 관계의 개수

        int[] edgeCount = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 그래프 각 노드별 인접한 노드정보 초기화
            graph.get(from).add(to);

            // 1. 그래프의 각 노드들의 진입 차수 테이블을 계산한다.
            edgeCount[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 2. 차수가 0인 노드를 큐에 넣는다. ( 현재기준, 선행작업이 없는 노드 )
        for (int i = 1; i <= n; i++) {
            if (edgeCount[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            // 값을 꺼내는 대로 결과창에 넣어줌
            sb.append(poll).append(" ");
            // 3. 꺼낸 노드와 간선으로 연결된 노드를 가져온다.
            List<Integer> list = graph.get(poll);


            for (int i = 0; i < list.size(); i++) {
                int aroundNum = list.get(i);
                // 4. 꺼낸 노드와 간선으로 연결된 노드들의 진입차수들을 감소시킨다.
                edgeCount[aroundNum]--;

                // 5. 진입차수 테이블을 갱신한 이후, 진입차수 값이 0이 된다면 큐에 넣어준다.
                if (edgeCount[aroundNum] == 0)   queue.add(aroundNum);
            }
        }

        System.out.println(sb);
    }
}
