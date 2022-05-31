package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        int check[] = new int[100001];

        q.add(start);
        check[start] = 1;

        // 시작값과 목표 값이 같을 경우
        if (start == target) {
            System.out.println(0);
        }else{
            while (!q.isEmpty()) {
                int temp = q.poll();

                for (int i = 0; i < 3; i++) {
                    int next;

                    // 3가지 경우의 수를 모두 넣어줌
                    if (i == 0) {
                        next = temp + 1;
                    } else if (i == 1) {
                        next = temp - 1;
                    }else{
                        next = temp * 2;
                    }

                    if (next == target) {
                        System.out.println(check[temp]);
                        return;
                    }

                    // 범위를 벗어나지 않고, 한번도 방문하지 않았다면
                    if (next >= 0 && next < check.length && check[next] == 0) {
                        // 현재 값을 큐에 넣고, check[next] 값을 갱신시켜줌
                        q.add(next);
                        check[next] = check[temp] + 1;
                    }
                }

            }
        }
    }
}
