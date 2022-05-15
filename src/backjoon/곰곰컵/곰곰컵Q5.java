package backjoon.곰곰컵;

import java.util.*;

public class 곰곰컵Q5 {

    static ArrayList<ArrayList<Integer>> router = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();


        for (int i = 0; i < n + 1; i++) {
            router.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            router.get(a).add(b);
        }

        // 정점의 개수
        int S = scan.nextInt();
        int pan[] = new int[S];
        for (int i = 0; i < S; i++) {
            pan[i] = scan.nextInt();
        }

        boolean result = false;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean onecheck = true;
        // 1번위치에 팬클럽이 있는 경우 체크
        for (int p : pan) {
            // 팬클럽이 있을 경우 빠져나옴
            if (p == 1) {
                onecheck = false;
                break;
            }
        }

        if(onecheck) {
            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : router.get(cur)) {
                    boolean check = true;
                    for (int p : pan) {
                        // 팬클럽이 있을 경우 빠져나옴
                        if (p == next) {
                            check = false;
                            break;
                        }
                    }

                    // 팬클럽이 없을 경우만 q에 삽입
                    if (check) q.add(next);

                }
                if (router.get(cur).size() == 0) {
                    result = true;
                    break;
                }
            }
        }

        if (result) {    // 팬클럽이 없이 이동할수 있다면,
            System.out.println("yes");
        }else{           // 팬클럽이 없이 이동할 방법이 없다면,
            System.out.println("Yes");
        }

    }
}

