package programmers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println( m.solution(20, 36));
        System.out.println(m.solution(100, 83));
        System.out.println(m.solution(12, 10));
    }

    // N -> N이하의 소수 (2<= N <= 3000000)
    // M -> N이하의 소수를 활용하여 연속된 소수의 합이 M이 되는 경우의 수가 얼마인지 2<= M <= 10억
    public int solution(int N, int M){
        int answer = 0;
        int[] primeArray = getPrimeArray(N);

        for(int i = 0; i < primeArray.length; i++){
            int sum = primeArray[i];

            // 처음값이 같은 경우
            if(sum == M){
                answer++;
                continue;
            }

            for (int j = i+1; j < primeArray.length; j++) {
                sum += primeArray[j];
                // 같은경우
                if(sum == M){
                    answer++;
                    break;
                //큰경우
                }else if(sum > M){
                    break;
                }else{ //작은 경우
                    continue;
                }
            }

        }
        return answer;
    }

    /**
     * n 이하의 소수 배열을 가져오기
     */
    private int[] getPrimeArray(int n) {
        ArrayList<Integer> primeArray = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if(isPrime(i)) primeArray.add(i);
        }

        return primeArray.stream().mapToInt(i->i).toArray();
    }

    /**
     * 소수 판별
     */
    private boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}