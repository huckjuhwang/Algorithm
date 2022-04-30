package 동빈나.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    static int N, M, K, start;

/**
4 4 2 1
1 2
1 3
2 3
2 4


 */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 노드개수
        N = Integer.parseInt(st.nextToken());
        // 간선개수
        M = Integer.parseInt(st.nextToken());
        // 출발지부터 도착해야하는 거리정보
        K = Integer.parseInt(st.nextToken());
        // start번호
        start = Integer.parseInt(st.nextToken());

        int arr[][] = new int[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y]++;
        }

        Queue<search> q = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= M; i++) {
            if (arr[start][i] != 0) {
                q.offer(new search(start, i, 1));
            }
        }

        while (!q.isEmpty()) {
            search poll = q.poll();
            int stat = poll.getTo();

            if (map.get(poll.getTo()) == null) {
                map.put(poll.getTo(), poll.getDepth());
            }else{
                // 있을 경우 value비교 후 더 낮은 값으로 세팅
                if (map.get(poll.getTo()) > poll.getDepth()) {
                    map.put(poll.getTo(), poll.getDepth());
                }
            }
            for (int i = 1; i <= M; i++) {
                // 연결되어 있다면
                if (arr[stat][i] != 0) {
                    q.offer(new search(start, i, poll.getDepth() + 1));
                }
            }
        }
        boolean check = false;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) == K) {
                System.out.println(key);
                check = true;
            }
        }

        if (!check) {
            System.out.println("-1");
        }


    }
}

class search {
    private int from;
    private int to;
    private int depth;

    public search(int from, int to, int depth) {
        this.from = from;
        this.to = to;
        this.depth = depth;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
