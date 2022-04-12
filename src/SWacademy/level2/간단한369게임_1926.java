package SWacademy.level2;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.codehaus.groovy.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한369게임_1926 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for( int i=1; i<=n; i++){
            String empty = "";
            int num = i;
            
            while (num != 0) {
                if(((num % 10) == 3)||((num % 10) == 6) || ((num % 10) == 9)){
                    empty += "-";
                }
                num /= 10;
            }

            if (empty.length() == 0) {
                System.out.print(i + " ");
            }else {
                System.out.print(empty + " ");
            }
            
        }
    }

}
