package 구름EDU.공간활용하기;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 네카드 {

    public static void main(String[] args) throws IOException {

        // 입력값을 받기 위한 로직
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int target[] = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<PairSum> pair = new ArrayList<>();
        // 두개의 합한 조합을 List에 삽입
        // n의 최대 개수는 1000;
        // O(N^2)
        for (int p : arr) {
            for (int q : arr) {
                pair.add(new PairSum(p, q));
            }
        }
        // binarySearch를 수행하기 위한 정렬
        Collections.sort(pair);
        ArrayList<Integer> result = new ArrayList<>();

        for (int k : target) {
            // target = (p+q) + (r+s)
            // (r+s) = target - (p+q)
            for (PairSum p_plus_q : pair) {
                int r_plus_s = k - p_plus_q.sum;
                if (Collections.binarySearch(pair, new PairSum(r_plus_s)) >=0) {
                    result.add(k);
                    break;
                }
            }
        }

        // 실제로 만들수 있는 당점번호가 여러개라면 오름차순 정렬
        Collections.sort(result);
        // 당첨번호가 존재하지 않을 경우
        if (result.size() == 0) {
            System.out.println("NO");
        }else{
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }
}


class PairSum implements Comparable<PairSum>{

    int card1;
    int card2;
    int sum;

    public PairSum(int card1, int card2) {
        this.card1 = card1;
        this.card2 = card2;
        this.sum = this.card1 + this.card2;
    }

    public PairSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public int compareTo(PairSum o) {
        return this.sum - o.sum;
    }
}