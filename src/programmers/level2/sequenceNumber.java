package programmers.level2;

class sequenceNumber {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length};

        int left = 0;
        int right = 1;

        int sum = sequence[0];

        while(left < right) {
            if(sum == k) {
                if(right-1-left < answer[1]-answer[0]) {
                    // right는 다음 더할 값을 포인터로 가지고 있기때문에 현재 sum에 대한 포인터를 저장
                    answer[1] = right -1;
                    answer[0] = left;
                }
                sum -= sequence[left++];
            } else if(sum > k) {
                sum -= sequence[left++];
            } else if(right < sequence.length) {
                sum += sequence[right++];
            } else {
                break;
            }
        }
        return answer;
    }
}
