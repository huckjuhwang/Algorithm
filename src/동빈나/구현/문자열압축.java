package 동빈나.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {

    public static void main(String[] args) throws IOException {

//        String s = ""
//        for (int i = 0; i < ; i++) {
//
//        }
    }

    public int solution(String s) {
        int answer = s.length();

        for (int step = 1; step < s.length()/2+1; step++) {
            // step에 맞는 단어 추출
            String preStr = s.substring(0, step);
            String nextStr = "";
            String result = "";
            int count = 1;

            for (int i = step; i < s.length(); i+=step) {
                nextStr = "";
                for (int j = i; j < i+step; j++) {
                    if (j < s.length())   nextStr += s.charAt(j);
                }
                // 이전 문자와 현재문자가 같다면
                if (nextStr.equals(preStr)) {
                    count++;
                }else{  // 같지 않다면,
                    result += (count >= 2) ? count + preStr : preStr;
                    // 초기화
                    nextStr = "";
                    for (int j = i; j < i+step; j++) {
                        if (j < s.length())   nextStr += s.charAt(j);
                    }

                    preStr = nextStr;
                    System.out.println(preStr);
                    count = 1;
                }
            }

            result += (count >= 2) ? count + preStr : preStr;
            answer = Math.min(answer, result.length());
        }
        return answer;
    }

}
