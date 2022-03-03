package programmers;

public class measureSum {

    public static void main(String[] args) {
        System.out.println(solution(13, 14));
    }

    public static int solution(int left, int right) {
        int sum = 0;

        for( int i=left; i<=right; i++){
            if (calculate(i)){
                sum += i;
            }else {
                sum -= i;
            }
        }
        return sum;
    }

    // 짝수면 ture
    public static boolean calculate(int x){
        int cnt = 0;
        for(int i=1; i<=x; i++){
            if(x % i ==0){
                cnt++;
            }
        }
        return cnt%2==0;
    }

}
