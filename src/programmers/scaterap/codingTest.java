package programmers;

public class codingTest {

    class Score {
        int score;
        int day;

        public Score(int score, int day){
            this.score = score;
            this.day = day;
        }
    }

    // 하늘 점수
    public static final int sunny = 20;
    public static final int manyCloud = 17;
    public static final int cloudy = 10;

    // 강수 점수
    public static final int rain = 5;
    public static final int snow = 14;

    // 요일 점수
    int dayScore[];
    // 온도점수
    int temperScore;
    // 날씨점수
    int weatherScore;

    // 최소/최대 스코어 및 요일
    Score minScore;
    Score maxScore;


    public static final int monday = 0;
    public static final int tuesday = 1;
    public static final int wednesday = 2;
    public static final int thursday = 3;
    public static final int friday = 4;
    public static final int saturday = 5;
    public static final int sunday = 6;


    public static final int DAY = 1;
    public static final int SCORE = 0;


    // 토 -> 금 -> 일 -> 수 -> 목 -> 화 -> 월 : 우선순위
//    public static void main(String[] args) {
//        codingTest ct = new codingTest();
//        ct.solution(new int[][]{{1, 0, 11}, {3, 1, 15}, {2, 0, 16}, {4, 0, 17}, {2, 0, 15}, {2, 1, 14}, {2, 0, 12}});
//    }

    public int[] solution(int[][] data) {

        int[] dateYesOrNo = new int[2];
        initScore(data);

        // 요일 값을 판단하기 위한 값
        int idx = 0;

        for( int day[] : data ){
            int skyScore = getSkyScore(day[0]);
            int rainScore = getRainScore(day[1]);
            setDayScore(day[2], getWeatherScore(skyScore, rainScore), idx);
            idx++;
        }

        // 소개팅 해야되는날 세팅
        dateYesOrNo[0] = getYesDate();
        // 소개팅하면 안되는날 세팅
        dateYesOrNo[1] = getNoDate(data);

        return dateYesOrNo;
    }

    /**
     * 변수 초기화
     */
    private void initScore(int[][] data) {
        minScore = new Score(50, 0);
        maxScore = new Score(0, 0);

        dayScore = new int[data.length];
    }

    /**
     * 데이트 해야하는 요일
     */
    private int getYesDate() {
        return maxScore.day;
    }


    /**
     * 데이트 하면 안되는 요일
     * 없으면 -1
     */
    private int getNoDate(int[][] data) {
        // 우선순위 : 월 -> 화 -> 목 -> 수 -> 일 -> 금 -> 토 ( 조건에는 없지 만 필요해 보임 )
        // 구현
        int idx = minScore.day;

        if( data[idx][0] == 4 || data[idx][1] == 1 ) {
            return idx;
        }else if( data[idx][2] >= 30 ){
            return idx;
        }else if( data[idx][2] <=0 ){
            return idx;
        }
        return -1;
    }

    /**
     * 요일 날짜 점수 세팅
     */
    private void setDayScore(int nowTemper, int pi_weatherScore, int idx) {
        temperScore = getTemperatures(nowTemper);
        weatherScore = pi_weatherScore;

        dayScore[idx] = temperScore + weatherScore;

        // 최대/최소 score 요일 구하기
        setMaxScore(idx);
        setMinScore(idx);
    }


    /**
     * 요일 날짜 점수 세팅
     */
    private void setMaxScore(int idx) {
        // 토 -> 금 -> 일 -> 수 -> 목 -> 화 -> 월 : 우선순위
        // 구현 해야됨
        if( dayScore[idx] > maxScore.score ){
            maxScore.score = dayScore[idx];
            maxScore.day = idx;
        }
        // 우선순위
        // 동점인 경우
        if( dayScore[idx] == maxScore.score ){
            equalsScorePriority(idx);
        }
    }

    /**
     * 점수 같을 경우 우선순위
     */
    private void equalsScorePriority(int idx) {
        switch (idx) {
            case monday:
                break;
            case tuesday:
                if ( maxScore.day == 0 )
                    maxScore.day = idx;
                break;
            case wednesday:
                if ( maxScore.day == 0 || maxScore.day == 1 || maxScore.day == 3 )
                    maxScore.day = idx;
                break;
            case thursday:
                if ( maxScore.day == 0 || maxScore.day == 1 )
                    maxScore.day = idx;
                break;
            case friday:
                if ( maxScore.day == 0 || maxScore.day == 1 || maxScore.day == 3 || maxScore.day == 2 || maxScore.day == 6 )
                    maxScore.day = idx;
                break;
            case saturday:
                maxScore.day = idx;
                break;
            case sunday:
                if ( maxScore.day == 0 || maxScore.day == 1 || maxScore.day == 3 || maxScore.day == 2 )
                    maxScore.day = idx;
        }
    }

    /**
     * 최소 score 요일 구하기
     */
    private void setMinScore(int idx) {
        if( dayScore[idx] < minScore.score ){
            minScore.score = dayScore[idx];
            minScore.day = idx;
        }
    }

    /**
     * 날씨점수를 가져오는 함수
     *  max : 20
     */
    private int getWeatherScore(int skyScore, int rainScore) {
        int weatherScore = skyScore + rainScore;
        if ( weatherScore > 20 ) {
            weatherScore = 20;
        }
        return weatherScore;
    }

    /**
     * 강수상태점수를 가져오는 함수
     */
    private int getRainScore(int pi_rainCode) {
        int rainScore = 0;
        int rainCode = pi_rainCode;
        if( rainCode == 1 ){
            rainScore = rain;
        }else if ( rainCode == 2 ) {
            rainScore = snow;
        }
//        else if ( rainCode == 0 ){     // 비나 눈이 오지 않으면 가장 점수가 높을 것으로 예상.
//            rainScore = 20;
//        }
        return rainScore;
    }


    /**
     * 하늘상태점수를 가져오는 함수
     */
    private int getSkyScore(int pi_skyCode) {
        int skyScore = 0;

        int skyCode = pi_skyCode;
        if (skyCode == 1 || skyCode == 2) {
            skyScore = sunny;
        } else if ( skyCode == 3 ){
            skyScore = manyCloud;
        } else if ( skyCode == 4 ){
            skyScore = cloudy;
        }
        return skyScore;
    }


    /**
     * 기온 점수를 가져오는 함수
     */
    private int getTemperatures(int now) {
        return 20 - Math.abs(22 - now);
    }


}