package backjoon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int count[] = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            count[to]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if( count[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            sb.append(poll).append(" ");
            ArrayList<Integer> list = graph.get(poll);

            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                count[num]--;
                if( count[num] == 0 ) queue.add(num);
            }

        }

        System.out.println(sb);

    }
}
