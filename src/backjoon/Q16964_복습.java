package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q16964_복습 {

    static boolean visit[];
    static int arr[];
    static boolean check;
    static ArrayList<ArrayList<Integer>> graph;
    static int idx= 1;

    static int FAIL = 0;
    static int SUCCESS = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        arr = new int[n+1];
        visit = new boolean[n+1];
        check = true;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] != 1) {
            System.out.println(0);
            return;
        }

        dfs(1);

        if (check) {
            System.out.println(SUCCESS);
        }else{
            System.out.println(FAIL);
        }

    }

    // 현재 노드의 값을 매개변수로 넘겨줌
    public static void dfs(int x) {
        if( visit[x] ) return;
        visit[x] = true;


        HashSet<Integer> set = new HashSet<>();
        for (int num :  graph.get(x)) {
            if (!visit[num]) {
                // num 연결된 노드의 집합을 모두 넣어준다
                set.add(num);
            }
        }


        if(set.size() == 0) return;
        if (set.contains(arr[idx])) {
//            int nextIDX= idx+1;
            dfs(arr[idx++]);
        }else{
            check = false;
        }
    }


}
