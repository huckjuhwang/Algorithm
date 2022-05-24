package backjoon.분리집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1717 {

    static int root[];
    final static int CHECK = 1;
    final static int UNION = 0;

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        root[a] = b;
    }

    public static int find(int x) {
        if (root[x] == x)  return x;
        return root[x] = find(root[x]);
    }


    public static boolean check(int x, int y) {
        return find(x) == find(y) ? true : false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int m = Integer.parseInt(st.nextToken()); // 명령어 개수
        StringBuilder result = new StringBuilder();

        root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int action = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (action == UNION) {
                union(a, b);
            } else if (action == CHECK) {
                if (check(a, b)) {
                    result.append("YES").append("\n");
                }else{
                    result.append("NO").append("\n");
                }
            }
        }
        System.out.println(result);
    }
}
