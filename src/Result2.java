import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result2 {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY projectCosts
     *  2. INTEGER target
     */



    public static int countPairs(List<Integer> projectCosts, int target) {
        // Write your code here

        Map<Integer, Integer> costMap = new HashMap<>();
        for (int number: projectCosts) {
            if(costMap.get(number) == null) {
                costMap.put(number, 1);
            } else {
                costMap.put(number, costMap.get(number) + 1);
            }
        }

        List<Integer> newCosts = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : costMap.entrySet()) {
            newCosts.add(entry.getKey());
        }

        int n = newCosts.size();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int number = Math.abs(newCosts.get(i) - newCosts.get(j));

                if(number == target) {
                    count++;
                }

            }
        }

        return count;
    }


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(5);
        l.add(3);
        l.add(4);
        l.add(2);


        int i = countPairs(l, 2);
        System.out.println(i);
    }

}