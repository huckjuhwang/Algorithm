package programmers.hash;

import java.util.Arrays;

public class phoneNumber {

    public static void main(String[] args) {
        phoneNumber pn = new phoneNumber();
        boolean solution = pn.solution(new String[]{"3", "32", "324"});

        System.out.println("solution = " + solution);
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for ( int i=0; i<phone_book.length-1; i++){
            if ( phone_book[i+1].startsWith(phone_book[i]) ){
                return false;
            }
        }
        return true;
    }

}
