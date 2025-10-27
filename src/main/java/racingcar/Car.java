package racingcar;

final class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    void move() {
        position += 1;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }
}
