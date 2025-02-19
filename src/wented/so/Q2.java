package wented.so;

public class Q2 {

    public static void main(String[] args) {
    }


    public static int solution(int[] numbers, int k) {
        return -1;
    }


    public static boolean check(int[] numbers, int k) {
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] - numbers[i-1] < k) {
                return false;
            }
        }
        return true;
    }
}
