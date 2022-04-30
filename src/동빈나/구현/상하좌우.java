package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우 {
    // 상, 하, 좌, 우
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static String moveTypes[] = {"U", "D", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int len = st.countTokens();
        int x = 1;
        int y = 1;

        for (int i = 0; i < len; i++) {
            String route = st.nextToken();
            int nx = -1, ny = -1;
            for (int j = 0; j < moveTypes.length; j++) {
                if (route.equals(moveTypes[j])) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }


            if ( nx < 1 || nx > n || ny < 1 || ny > n) continue;

            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
