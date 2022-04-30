package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i <= h; i++) {
            if (i == 3 || i == 13) {
                count += 3600;
                continue;
            }else {
                for (int j = 0; j <= 59; j++) {
                    for (int k = 0; k <= 59; k++) {
                        if (String.valueOf(j).contains("3") || String.valueOf(k).contains("3")) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
