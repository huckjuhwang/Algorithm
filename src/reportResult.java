import java.util.*;

public class reportResult {
    public static void main(String[] args) {
        System.out.print("test");
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0]];

        if( arr1.length == 0 ) return answer;

        for (int i=0; i<arr1.length; i++){
            for( int j=0; j<arr1[0].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
