package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 0,0부터 시작
        int x = (str.charAt(1) - '0') - 1;
        int y = str.charAt(0) - 'a';

        // 방향 벡터 지정
        int dx[] = {-2, -2, -1, 1, 2, 2, -1, 1};
        int dy[] = {1, -1, 2, 2, 1, -1, -2, -2};
        int count = 0;

        for (int i = 0; i < dx.length; i++) {
            // 이동
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위안에 존재한다면,
            if (!(nx < 0 || ny < 0 || nx > 7 || ny > 7)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
