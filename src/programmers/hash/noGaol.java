package programmers.hash;

import java.util.*;

public class noGaol {
    public static void main(String[] args) {
        noGaol ng = new noGaol();
        System.out.println( ng.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {
        List<String> part = new ArrayList<>();

        setParticipant(participant, part);
        checkCompletion(completion, part);
        return part.get(0);
    }

    private void checkCompletion(String[] completion, List<String> part) {
        for( String cpt : completion){
            if (part.contains(cpt)){
                part.remove(cpt);
            }
        }
    }

    private void setParticipant(String[] participant, List<String> part) {
        for( String ptp : participant){
            part.add(ptp);
        }
    }
}
