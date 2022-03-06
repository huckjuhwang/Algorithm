package programmers;

public class Main12 {


    public double solution(double C, double F, double X){
        double answer = 0.0;

        int partJob = 0;
        //아르바이트를 쓰지 않는 경우
        answer = X/2;
        double arbeitcost = 0.0;

        while(true){
            double tempAnswer = 0.0;
            partJob++;

            arbeitcost += C/(((partJob - 1)*F)+2);
            tempAnswer += arbeitcost;
            tempAnswer += X/((partJob*F) + 2);

            if (answer > tempAnswer){
                answer = tempAnswer;
            }else{
                break;
            }
        }
        return (Math.round(answer*1000000.0)/1000000.0);
    }

}
