package wented.to;

class Q3 {

    public static boolean isValidNumberFormat(String amountText) {
        // 숫자와 쉼표, '+', '-'로만 구성된 패턴 정의
        String pattern = "^[\\d,+\\-]+$";

        // 정규식 패턴과 문자열 비교
        if (!amountText.matches(pattern)) {
            return false; // 숫자와 쉼표, '+', '-' 이외의 문자가 포함된 경우
        }

        // 숫자와 쉼표로만 구성된 문자열인 경우, 숫자 형식을 추가적으로 검증
        return amountText.matches("^\\d{1,3}(,\\d{3})*$");
    }

    public static boolean solution(String amountText) {
        boolean answer = true;

        // 0인 경우 체크
        if(amountText.equals("0")) {
            return true;
        }

        // 첫번째 글자 체크
        if(amountText.charAt(0) == '0') {
            return false;
        }

        try {
            Integer.parseInt(amountText);
        } catch (Exception e) {
            return isValidNumberFormat(amountText);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("+300"));
    }
}