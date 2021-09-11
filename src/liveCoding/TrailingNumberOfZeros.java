package liveCoding;

/**
 * N!의 맨뒤 0의 개수를 구하라!
 */
public class TrailingNumberOfZeros {

    private int factorialNumber;  // factorial 넘버
    private int twoCount;  // 2의 개수
    private int fiveCount;  // 5의 개수

    public TrailingNumberOfZeros(int factorialNumber) {
       this.factorialNumber = factorialNumber;
       this.twoCount = 0;
       this.fiveCount = 0;
    }

    public static void main(String[] args) {
        TrailingNumberOfZeros num = new TrailingNumberOfZeros(100);
        System.out.println("process = " + num.process());
    }


    /**
     * 핵심 비지니스 로직
     * @return
     */
    public int process(){
        int temp = 0;

        for ( int i = 2; i<=factorialNumber; i++){
            temp = i;

            while ( temp%5==0 ){
                fiveCount++;
                temp /= 5;
            }

            while ( temp%2==0 ) {
                twoCount++;
                temp /= 2;
            }
        }
        return  twoCount < fiveCount ? twoCount : fiveCount;
    }
}
