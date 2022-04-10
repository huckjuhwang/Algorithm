package wented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long cnt = 0;
        int WPoint =0;
        int HPoint;
        int ECnt = 0;


        while( WPoint != N ){
            char W = str.charAt(WPoint++);
            if( W != 'W' ){
                continue;
            }

            // W다음 포인터를 H로 잡고 H를 찾음
            HPoint= WPoint;

            // E는 최소 2개는 나와야함
            while( HPoint != (N-2) ){
                char H = str.charAt(HPoint++);
                if( H == 'H'){
                    // E개수 세기
                    for (int i = HPoint; i < N; i++) {
                        char E = str.charAt(i);
                        if( E == 'E'){
                            ECnt++;
                        }
                    }

                    // E 개수를 통한 연산
                    if( ECnt == 2 ) {
                        cnt += 1;
                    }else if ( ECnt > 2 ){
                        cnt += ((ECnt * (ECnt - 1)/2) +1);
                    }
                    ECnt = 0;
                }
            }
        }
        System.out.println(cnt % 1000000007);
    }
}