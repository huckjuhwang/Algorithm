package wented.s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            // 그래프 형태 구축
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                graph.add(new ArrayList<>());

            // 선행작업 테이블 생성
            int count[] = new int[n + 1];
            for (int from = 1; from <= n; from++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                // 관계 개수
                int m = Integer.parseInt(st.nextToken());

                // 각 관계에 대해서 선행작업 테이블 갱신 / 그래프 갱신
                for (int j = 0; j < m; j++) {
                    int to = Integer.parseInt(st.nextToken());
                    graph.get(to).add(from);
                    count[from]++;
                }
            }

            // 선행작업이 없는 노드 queue 삽입
            Queue<Point> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0)  q.add(new Point(1, i));
            }

            int depth = -1;
            while (!q.isEmpty()) {
                Point temp = q.poll();

                ArrayList<Integer> list = graph.get(temp.value);
                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);

                    // 선행작업 테이블을 갱신해줌
                    count[num]--;
                    if (count[num] == 0) {
                        q.add(new Point(temp.depth+1, num));
                        depth = temp.depth + 1;
                    }
                }
            }


            // 루프여부 체크
            boolean loop = false;
            for (int i = 1; i <= n; i++) {
                if( count[i] != 0 ){
                    loop = true;
                    break;
                }
            }

            // 루프일 경우 -1 출력
            if (!loop) {
                System.out.println("#" + testCase + " " + depth);
            }else{
                System.out.println("#" + testCase + " " + -1);
            }
        }
    }


}

class Point{
    public int depth;       // 현재노드의 depth
    public int value;       // 선행 작업의 개수

    public Point(int depth, int value) {
        this.depth = depth;
        this.value = value;
    }
}
