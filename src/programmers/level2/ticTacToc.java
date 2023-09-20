package programmers.level2;

class ticTacToc {

    /**
     * O의 개수-X의 개수=0 or 1
     * O가 이겼다면 O의 개수는 X보다 한 개 많음.
     * X가 이겼다면 O의 개수와 X의 개수는 같음.
     * O와 X는 동시에 이길 수 없음.
     *
     * 이거 4개만 체크하면 통과
     *
     * 0 -> 잘못된 상황
     * 1 -> 옳은 상황
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"OXO", "XOX", "OXO"}));
    }

    public static int solution(String[] board) {
        String[][] boardMap = new String[3][3];

        int yesCount = 0;
        int noCount = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                boardMap[i][j] = board[i].charAt(j) + "";
                if(boardMap[i][j].equals("O")){
                    yesCount++;
                } else if(boardMap[i][j].equals("X")) {
                    noCount++;
                }
            }
        }

        int count = yesCount - noCount;
        if(count != 0 && count != 1){
            return 0;
        }

        int yesBingo = 0;
        int noBingo = 0;

        for(int i=0; i<3; i++) {
            if(boardMap[i][0].equals(boardMap[i][1]) && boardMap[i][1].equals(boardMap[i][2])) {
                if(boardMap[i][0].equals("O")){
                    yesBingo++;
                } else if(boardMap[i][0].equals("X")) {
                    noBingo++;
                }
            }

            if(boardMap[0][i].equals(boardMap[1][i]) && boardMap[1][i].equals(boardMap[2][i])) {
                if(boardMap[1][i].equals("O")){
                    yesBingo++;
                } else if(boardMap[1][i].equals("X")) {
                    noBingo++;
                }
            }
        }

        if(boardMap[0][0].equals(boardMap[1][1]) && boardMap[1][1].equals(boardMap[2][2])) {
            if(boardMap[1][1].equals("O")){
                yesBingo++;
            } else if(boardMap[1][1].equals("X")) {
                noBingo++;
            }
        }

        if(boardMap[2][0].equals(boardMap[1][1]) && boardMap[1][1].equals(boardMap[0][2])) {
            if(boardMap[1][1].equals("O")){
                yesBingo++;
            } else if(boardMap[1][1].equals("X")) {
                noBingo++;
            }
        }

        // no와 yes는 동시에 이길수 없음
        if(yesBingo != 0 && noBingo != 0) {
            return 0;
        }

        // yes가 이긴경우 0의 갯수가 1개 더많음
        if(yesBingo != 0 && yesCount != noCount +1) {
            return 0;
        }

        // no가 이긴경우 갯수가 동일함
        if(noBingo != 0 && noCount != yesCount) {
            return 0;
        }

        return 1;
    }
}