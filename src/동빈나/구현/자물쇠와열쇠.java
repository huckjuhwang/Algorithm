package 동빈나.구현;

/**
 * 테스트 케이스 23번 오류..
 */
public class 자물쇠와열쇠 {
    public static void main(String[] args) {
//        System.out.println(solution(
//                new int[][]{{0, 0, 0, 1},
//                        {1, 0, 0, 1},
//                        {1, 1, 1, 1},
//                        {1, 1, 1, 1}},
//                new int[][]{{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}}));

//        System.out.println(solution(
//                new int[][]{{0, 0},
//                        {1, 0}},
//                new int[][]{{1, 1},
//                        {1, 1}}));

        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));

    }

    public static boolean solution(int[][] key, int[][] lock) {
        // lock size에서 더 큰값으로 만듬.
        int lock_full_size = lock.length * 3 -2;
        int lock_full[][] = new int[lock_full_size][lock_full_size];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                lock_full[lock.length - 1 + i][lock.length - 1 + j] = lock[i][j];
            }
        }


        for (int rotation = 0; rotation < 4; rotation++) {
            // 90도 회전
            key = arrTurn(key);

            for (int k = 0; k < lock.length*2-1; k++) {
                for (int q = 0; q < lock.length*2-1; q++) {
                    // 돌린 key를 가지고 현재 lock에 넣어보기
                    for (int i = 0; i < key.length; i++) {
                        for (int j = 0; j < key.length; j++) {
                            lock_full[k+i][q+j] += key[i][j];
                        }
                    }

                    // 열쇠가 맞는지 검사
                    if( isValid(lock_full) ){
                        return true;
                    } else{
                        // 열쇠가 맞지 않는다면 다시 롤백
                        for (int i = 0; i < key.length; i++) {
                            for (int j = 0; j < key.length; j++) {
                                lock_full[k+i][q+j] -= key[i][j];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 90도 회전하는 메서드
     */
    public static int[][] arrTurn(int[][] key){
       int[][] temp = new int[key.length][key[0].length];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = key[key.length-1-j][i];
            }
        }
        return temp;
    }

    /**
     * 삽입한 키가 일치하는지 여부 파악
     */
    public static boolean isValid(int lock_full[][]) {
        int lockLength = ((lock_full.length+2) / 3) ;
        for (int i = lockLength; i < lockLength * 2-1; i++) {
            for (int j = lockLength; j < lockLength * 2-1; j++) {
                if (lock_full[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
