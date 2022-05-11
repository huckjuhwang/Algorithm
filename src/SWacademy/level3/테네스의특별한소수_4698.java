package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 테네스의특별한소수_4698 {
    static int MAX_SIZE =1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // 에라토스테네스의 체를 사용하여 1000000까지의 소수를 계산
        List<Integer> primes = getPrime();

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int num : primes) {
                // 원하는 자연수 사이에 존재하면서,
                // number가 D의 값을 포함하고 있다면,
                if( num >= A && num <= B){
                    if (Integer.toString(num).contains(Integer.toString(D)))  count++;
                }
                // num이 B보다 커질 경우 이후 값은 보지 않아도됨(가지치기)
                if(num > B) break;
            }

            System.out.println("#" + testCase + " " + count);

        }
    }


    public static List<Integer> getPrime(){
        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[MAX_SIZE+1];

        for (int i = 2; i <= MAX_SIZE; i++) {
            // 체크되지 않았다면,
            if (!check[i]) {
                list.add(i);
                // 어떤 특정 소수의 배수가 되는 수는 소수가 될 수 없기때문에,
                // 소수가 아닌것으로 판별한다.
                for (int j = i + i; j <= MAX_SIZE; j += i) {
                    check[j] = true;
                }
            }
        }
        return list;
    }
}
