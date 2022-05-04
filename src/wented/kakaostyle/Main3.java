package wented.kakaostyle;

public class Main3 {

    // idx 기준으로 짝수보단 홀수가 값이 무조건 커야함
    // 현재 S를 순차탐색을 진행하며, 현재 탐색하는값을 IDX라고 했을때,
    // IDX 와 IDX+1을 비교해가며, 각 조건에 불일치 할 경우 count++;
    // s의 사이즈를 N이라고 했을때, 시간복잡도는 O(N)을 가지게 된다.
    public int solution(int[] s) {
        int count = 0;
        for (int i = 0; i < s.length-1; i++) {
            // 짝수일때
            if ((i % 2 == 0) && (s[i] >= s[i+1])) {
                count++;
            // 홀수일때
            } else if ((i % 2 == 1) && (s[i] <= s[i + 1])) {
                count++;
            }
        }
        return count;
    }
}
