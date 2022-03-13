package programmers.level2;

/**
 * n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 */
public class targetNumber {

    static int answer = 0;

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int depth, int sum){

        // 정답일 경우
        if( numbers.length == depth ) {
//            System.out.println("numbers = " + numbers);
            if (target == sum) {
                answer++;
            }
            return;
        }else{
            // +1을 했을경우
            dfs( numbers, target, depth+1, sum+numbers[depth]);
            // -1을 했을 경우
            dfs( numbers, target, depth+1, sum+(numbers[depth]*-1));
        }
    }


}
