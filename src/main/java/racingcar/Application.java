package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String names = readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String tryCountRaw = readLine("시도할 횟수는 몇 회인가요?");

        System.out.println();
        System.out.println("실행 결과");

        // 이후 커밋에서 파싱/실행/출력을 구현
        // 여기서는 입력만 받고 실행 결과 헤더까지만 출력
    }

    private static String readLine(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
