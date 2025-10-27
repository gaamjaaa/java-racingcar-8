package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int MOVE_THRESHOLD = 4;

    public static void main(String[] args) {
        String namesInput = readLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String tryCountInput = readLine("시도할 횟수는 몇 회인가요?");

        List<Car> cars = parseCars(namesInput);
        int tryCount = parseTryCount(tryCountInput);

        printExecutionHeader();
        runRounds(cars, tryCount);
    }

    private static String readLine(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    private static List<Car> parseCars(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("names required");
        }
        String[] nameTokens = raw.split(",");
        List<Car> cars = new ArrayList<>();
        for (String nameToken : nameTokens) {
            String name = nameToken.trim();
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
        String trimmedInput = raw.trim();
        if (trimmedInput.isEmpty()) {
            throw new IllegalArgumentException("try count required");
        }
        if (!trimmedInput.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("try count must be positive integer");
        }
        int tryCount = Integer.parseInt(trimmedInput);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("try count must be > 0");
        }
        return tryCount;
    }

    private static void printExecutionHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private static void runRounds(List<Car> cars, int tryCount) {
        for (int round = 0; round < tryCount; round++) {
            for (Car car : cars) {
                int pick = Randoms.pickNumberInRange(0, 9);
                if (pick >= MOVE_THRESHOLD) {
                    car.move();
                }
            }
            printRound(cars);
        }
    }

    private static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
