package programmers.level1;

public class reverseNumber {

    public static void main(String[] args) {
        int solution = solution(12345);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n%10;
            n /= 10;
        }
        return answer;
    }
}
