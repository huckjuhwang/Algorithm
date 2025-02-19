import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

//    www.abc.com
//    www.hd.com
//    www.abc.com
//    www.pqr.com
//    www.abc.com
//    www.pqr.com
//    www.pqr.com

    /**
     * www.abc.com
     * www.hd.com
     * www.abc.com
     * www.pqr.com
     * www.abc.com
     * www.pqr.com
     * www.pqr.com
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        List<String> result = getRequestStatus(List.of(new String[]{"www.abc.com", "www.hd.com", "www.abc.com", "www.pqr.com", "www.abc.com", "www.pqr.com", "www.pqr.com"}));
        System.out.println(result);
    }

    static String SUCCESS = "{status: 200, message: OK}";
    static String FAILURE = "{status: 429, message: Too many request}";

    public static List<String> getRequestStatus(List<String> requests) {
        // Write your code here

        List<String> result = new ArrayList<>(requests.size());

        for (int i = 0; i < requests.size(); i++) {
            String nowRequest = requests.get(i).split("[.]")[1];
            boolean check = true;

            // 5초전 2개 체크
            int count = 0;
            for (int j = i - 4; j < i; j++) {
                if (j < 0) {
                    continue;
                }

                String request = requests.get(j).split("[.]")[1];
                if (request.equals(nowRequest)) {
                    count++;
                }

                if (count == 2) {
                    check = false;
                }
            }

            if (check == false) {
                result.add(FAILURE);
                continue;
            }


            // 30초전 5개 체크
            count = 0;
            for (int j = i - 29; j < i; j++) {
                if (j < 0) {
                    continue;
                }

                String request = requests.get(j).split("[.]")[1];
                if (request.equals(nowRequest)) {
                    count++;
                }

                if (count == 5) {
                    check = false;
                }
            }

            if (check == false) {
                result.add(FAILURE);
                continue;
            }

            result.add(SUCCESS);
        }
        return result;
    }

    /**
     *
     * @param second 남은시간
     * @param maxCount 최대 갯수
     * @param start
     * @param nowRequest
     * @param requests
     * @return
     */
    private static boolean isFailure(int second, int maxCount, int start, String nowRequest, List<String> requests) {
        int count = 0;
        for (int j = start - second -1; j < start; j++) {
            if (j < 0) {
                continue;
            }

            String request = requests.get(j);
            if (request.equals(nowRequest)) {
                count++;
            }

            if (count == maxCount) {
                return false;
            }
        }

        return true;
    }
}