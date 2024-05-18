import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_FLOORS = 10;
        final int ELEVATOR_COUNT = 3;  // Поддержка 3 лифтов
        Building building = new Building(TOTAL_FLOORS, ELEVATOR_COUNT);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            building.displayStatus();
            System.out.print("Введите номер этажа (0-" + (TOTAL_FLOORS - 1) + ") или -1 для выхода: ");
            int floor = scanner.nextInt();

            if (floor == -1) {
                break;
            } else if (floor >= 0 && floor < TOTAL_FLOORS) {
                building.callElevator(floor);
                while (true) {
                    building.updateElevators();
                    building.displayStatus();
                    if (building.getElevatorCurrentFloor(floor) == floor) {
                        break;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Неверный этаж. Пожалуйста, введите номер от 0 до " + (TOTAL_FLOORS - 1) + ".");
            }
        }
        scanner.close();
    }
}
