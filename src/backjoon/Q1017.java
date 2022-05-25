package backjoon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Q1017 {

    static List<Integer> list[];
    static boolean oddVisited[], evenVisited[];
    static List<Integer> a, b;
    static int[] apair, bpair;

    // 에라토스테네스의 체 ( 2000보다 작거나 같은 수 )
    static boolean isPrime[];
    static int primeSize = 2000;

    static List<Integer> result;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = n / 2;

        a = new ArrayList<>();
        b = new ArrayList<>();

        isPrime = new boolean[primeSize+1];
        result = new ArrayList<>();
        // 에라토스테네스의체를 계산한다.
        setPrime(primeSize);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int first = Integer.parseInt(st.nextToken());
        a.add(first);

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 첫번째 숫자와, 이후 나온숫자 두개가 같으면 true
            if (!(isEven(first) ^ isEven(num))) {
                a.add(num);
            }else{
                b.add(num);
            }
        }
        // 짝수 + 홀수 개수는 소수임
        if (a.size() != b.size()) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }

        apair = new int[size];
        bpair = new int[size];
        check = new boolean[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPrime[a.get(i) + b.get(j)]) {
                    list[i].add(j);
                }
            }
        }


        for (int i = 0; i < list[0].size(); i++) {

            Arrays.fill(apair, -1);
            Arrays.fill(bpair, -1);

            // A와 B의 관계를 나타내는 곳에서 첫번째 원소는 고정으로 박음
            apair[0] = list[0].get(i);
            bpair[list[0].get(i)] = 0;

            int count = 1;
            for (int j = 1; j < size; j++) {
                Arrays.fill(check, false);
                if( dfs(j)) count++;
            }

            if( count == size) result.add(b.get(apair[0]));
        }

        if( result.size() == 0 ){
            System.out.println(-1);
            return;
        }

        for (int num : result) {
            System.out.print(num + " ");
        }

    }

    public static boolean dfs(int here) {
        for (int num : list[here]) {
            // 첫번째 리스트를 조회한다면 제거
            if (here == 0 | check[num])   continue;
            check[num] = true;

            // 지금 현재 b의 관계가 비어있거나, 아니면 옮길수 있는것 인지 확인
            // 0과 관련되어 있을 경우는 옮길수가 없음
            if (bpair[num] == -1 || dfs(num)) {
                apair[here] = num;
                bpair[num] = here;
                return true;
            }

        }
        return false;
    }




    public static void setPrime(int size){

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= size; i++) {
            if (isPrime[i]) {
                // i의 해당하는 제곱 수 모두 곱해준다. (Onlogn)
                for (int j = i*i; j <= size; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0 ? true : false;
    }


}
