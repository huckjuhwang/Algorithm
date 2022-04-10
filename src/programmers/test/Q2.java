package programmers.test;
import java.util.*;

public class Q2 {

    static int target = 0;
    static int[] nums;

    public static int solution(int[] numbers, int K) {
        int result = 0;
        int diff = 0;

        target = K;
        nums = numbers;
        int[] sortNumbers = new int[numbers.length];
        System.arraycopy(numbers, 0, sortNumbers, 0, sortNumbers.length);
        Arrays.sort(sortNumbers);


        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers = " + numbers[i]);
        }

        // 변경하지 않아도 될 경우
        diff = getLessThenKCnt(numbers);
        if (diff == 0) {
            return result;
        }
        // K이하의 원소의 차가 K이하가 될수 없는 경우
        diff = getLessThenKCnt(sortNumbers);
        if (diff > 0) {
            return -1;
        }

        result = 1;
        diff = 1;

        int max = 0;

        // step 05. numbers의 원소 개수 중 2개를 뽑는 조합의 수 계산(한쌍부터 시작)
        List<int[]> combinationList = getCombinationList(numbers.length);
        List<Integer> exceptIdxList = new ArrayList<>();
        Map<String,String> stop_map = new HashMap<>();
        stop_map.put("stop", "N");
        while (diff > 0) {
            System.arraycopy(numbers, 0, sortNumbers, 0, numbers.length);
            diff = findDiff(sortNumbers, combinationList, result, K, stop_map);
            if (diff > 0) {
                result++;
            }
        }

        return result;
    }


    public static int findDiff(int[] origin_arr, List<int[]> combinationList, int swap_count, int K, Map stop_map) {
        int diff = 1;

        outer:
        for (int a=0; a<combinationList.size(); a++) {
            if (stop_map.get("stop").equals("Y")) {
                break;
            }

            int[] temp_arr = new int[origin_arr.length];
            System.arraycopy(origin_arr, 0, temp_arr, 0, origin_arr.length);

            int[] case_arr = combinationList.get(a);
            int temp = temp_arr[case_arr[0]];
            temp_arr[case_arr[0]] = temp_arr[case_arr[1]];
            temp_arr[case_arr[1]] = temp;

            if (swap_count == 1) {
                diff = getLessThenKCnt(temp_arr, K, true);

                if (diff == 0) {

                    for (int i=0; i<temp_arr.length; i++) {
                        System.out.print(temp_arr[i]+",");
                    }
                    System.out.println();
                    stop_map.put("stop", "Y");
                    break;
                } else {
                    System.arraycopy(origin_arr, 0, temp_arr, 0, origin_arr.length);
                }
            } else {
                swap_count--;
                //exceptIdxList.add(a);
                diff = findDiff(temp_arr, combinationList, swap_count, K, stop_map);

                if (stop_map.get("stop").equals("Y")) {
                    break;
                }
                swap_count++;
            }
        }

        return diff;
    }


    /**
     * 인접한 위치의 차이가 K 이하인 경우
     */
    public static int getLessThenKCnt(int[] numbers, int K, boolean totalCheck) {
        int cnt = 0;
        int idx = 0;

        for (int num : numbers) {

        }
        for (int i=0; i<numbers.length-1; i++) {
            int num1 = numbers[i];
            int num2 = numbers[i+1];
            int diff = Math.abs(num1-num2);
            if (Math.abs(num1-num2) > K) {
                cnt++;
                if (!totalCheck) {
                    break;
                }
            }
        }
        return cnt;
    }

    /**
     * nCase에 대하여 2개를 고르는 콤비네이션 리스트를 반환
     */
    public static List<int[]> getCombinationList(int nCase) {

        /**
         * 1234
         *
         * 12
         * 13
         * 14
         * 23
         * 24
         * 34
         *
         */
        List<int[]> case_result = new ArrayList<>();
        for (int i=0; i<nCase-1; i++) {
            for (int j=i+1; j<nCase; j++) {
                int[] case_arr = new int[2];
                case_arr[0] = i;
                case_arr[1] = j;
                case_result.add(case_arr);

                //System.out.println(i+""+j);
            }
        }
        return case_result;

    }

    /**
     * 인접한 값이랑 차이가 K랑 가장 가까운것이 최적
     */
    public static int[] getChgIdxAndNum(int startIdx, int nextVal , int numbers[]) {
        int max=0;
        int idx=0;

        for (int i = startIdx; i < numbers.length; i++) {
            int diff = Math.abs(numbers[i]-nextVal);
            if (diff <= target && max < diff) {
                max = diff;
                idx = i;
            }
        }
        return new int[]{idx, max};
    }


    /**
     * 인접한 위치의 차이가 K 이상인 개수를 가져온다
     */
    public static int getLessThenKCnt(int[] numbers) {
        int result = 0;
        for (int i=0; i<numbers.length-1; i++) {
            int diff = Math.abs(numbers[i]-numbers[i+1]);
            if (diff > target) {
                result++;
            }
        }
        return result;
    }

    /**
     * nCase에 대하여 2개를 고르는 콤비네이션 리스트를 반환
     */
    public static List<int[]> getCombinationList(int nCase, int nextN) {

        List<int[]> result = new ArrayList<>();
        for (int i=0; i<nCase-1; i++) {
            for (int j=i+1; j<nCase; j++) {
                int[] case_arr = new int[2];
                case_arr[0] = i;
                case_arr[1] = j;
                result.add(case_arr);

                //System.out.println(i+""+j);
            }
        }
        return result;

    }

    public static void main(String[] args) {

        Q2 solution = new Q2();
        int result =  Q2.solution(new int[] {3,7,2,8,6,4,5,1}, 3);
        System.out.println(result);

    }

}
