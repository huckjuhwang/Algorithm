package 동빈나.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

public class 특정거리의도시찾기 {

    static ArrayList<ArrayList<Integer>> router = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        int x = scan.nextInt();

        int d[] = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            router.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            router.get(a).add(b);
        }
        Arrays.fill(d, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        d[x] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : router.get(cur)) {
                if (d[next] == Integer.MAX_VALUE) {
                    d[next] = d[cur] + 1;
                    q.offer(next);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if( d[i] == k ){
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println("-1");
        }
    }

}