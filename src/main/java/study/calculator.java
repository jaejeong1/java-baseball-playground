package study;

import java.util.Scanner;

public class calculator {
    // 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현
    // 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
    // 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다
    // 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        calculator ca = new calculator();
        // 입력 케이스
        // 숫자 / 사칙연산 기호
        // 앞에서 나온 순서대로 연산
        System.out.println(ca.calculate(input));
    }

    int calculate(String input) {
        String[] params = input.split(" ");
        int result = process(params[0], params[1], params[2]);
        for(int i=3; i< params.length; i+=2) {
            result = process(String.valueOf(result), params[i], params[i+1]);
        }
        return result;
    }

    int process(String a, String sign, String b) {
        if(sign.equals("+")) return Integer.parseInt(a) + Integer.parseInt(b);
        if(sign.equals("-")) return Integer.parseInt(a) - Integer.parseInt(b);
        if(sign.equals("*")) return Integer.parseInt(a) * Integer.parseInt(b);
        if(sign.equals("/")) return Integer.parseInt(a) / Integer.parseInt(b);
        return 0;
    }
}
