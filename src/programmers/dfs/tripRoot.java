package programmers.dfs;

import java.util.ArrayList;
import java.util.Collections;

public class tripRoot {

    boolean visited[];
    ArrayList<String> answer;

    public static final int SRC = 0;
    public static final int DES = 1;
    // test
    public static void main(String[] args) {

        tripRoot tr = new tripRoot();
        String[] solution = tr.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});

        for( String sol : solution ){
            System.out.println("sol = " + sol);
        }

    }

    public String[] solution(String[][] tickets) {

        initVariable(tickets);
        callDFS(tickets);
        Collections.sort(answer);

        for( int i=0; i<answer.size(); i++ ){
            System.out.println("answer = " + answer.get(i));
        }
        return answer.get(0).split(" ");
    }

    private void initVariable(String[][] tickets) {
        answer = new ArrayList(tickets.length+1);
        visited = new boolean[tickets.length];
    }

    private void callDFS(String[][] tickets) {
        dfs("ICN" ,"ICN", 0, tickets);
    }

    private void dfs(String start, String router, int cnt, String[][] tickets){
        if( cnt == tickets.length ){
            answer.add(router);
            return;
        }

        for ( int i=0; i<tickets.length; i++ ){
            if ( !visited[i] && tickets[i][SRC].equals(start) ){
                visited[i] = true;
                dfs(tickets[i][DES], router + " " + tickets[i][DES], cnt+1, tickets);
                visited[i] = false;
            }
        }
    }
}
