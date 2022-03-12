package liveCoding;

import java.util.ArrayList;
import java.util.List;


/**
 * 리스트에서 특정요소 안전하게 삭제하는 방법
 *
 */
public class removeData {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("kiwi");
        list.add("melon");
        list.add("banana");

        String temp ="tt";

//        for (String data : list) {
//            if (data.equals(temp)) {
//                list.remove(temp);
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
            String data = list.get(i);
            System.out.println("data = " + data);
            if( data.equals(temp)){
                list.remove(i);
            }
        }

        System.out.println();
        for (String data : list) {
            System.out.println("data = " + data);
        }
    }
}
