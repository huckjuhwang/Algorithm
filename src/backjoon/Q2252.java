package backjoon;

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
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 그래프 각 노드별 인접한 노드정보 초기화
            graph.get(from).add(to);
            edgeCount[to]++;
        }

        // 위상정렬에 사용 할 큐
        Queue<Integer> queue = new LinkedList<>();

        // 진입차수가 0이라면 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (edgeCount[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            // 값을 꺼내는 대로 결과창에 넣어줌
            sb.append(poll).append(" ");

            // 꺼낸 노드의 인접한 노드들을 가져온다.
            List<Integer> list = graph.get(poll);


            for (int i = 0; i < list.size(); i++) {
                int aroundNum = list.get(i);
                edgeCount[aroundNum]--;

                if (edgeCount[aroundNum] == 0)   queue.add(aroundNum);
            }
        }
        System.out.println(sb);
    }
}
