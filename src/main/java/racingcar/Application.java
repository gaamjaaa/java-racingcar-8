package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String names = readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String tryCountRaw = readLine("시도할 횟수는 몇 회인가요?");

        List<Car> cars = parseCars(names);
        int tryCount = parseTryCount(tryCountRaw);

        System.out.println();
        System.out.println("실행 결과");

        // 다음 커밋에서 게임 실행/출력 추가
    }

    private static String readLine(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    private static List<Car> parseCars(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("names required");
        }
        String[] parts = raw.split(",");
        List<Car> cars = new ArrayList<>();
        for (String p : parts) {
            String name = p.trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("empty name");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("name too long: " + name);
            }
            cars.add(new Car(name));
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("no cars");
        }
        return cars;
    }

    private static int parseTryCount(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("try count required");
        }
        String s = raw.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("try count required");
        }
        if (!s.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("try count must be positive integer");
        }
        int n = Integer.parseInt(s);
        if (n <= 0) {
            throw new IllegalArgumentException("try count must be > 0");
        }
        return n;
    }
}
