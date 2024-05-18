import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Elevator> elevators;
    private final int totalFloors;

    public Building(int totalFloors, int elevatorCount) {
        this.totalFloors = totalFloors;
        this.elevators = new ArrayList<>();
        for (int i = 0; i < elevatorCount; i++) {
            elevators.add(new Elevator(i + 1));  // лифт получает идентификатор
        }
    }

    public void callElevator(int destinationFloor) {
        Elevator nearestElevator = findNearestElevator(destinationFloor);
        nearestElevator.setDestinationFloor(destinationFloor);
    }

    public int getElevatorCurrentFloor(int destinationFloor) {
        Elevator nearestElevator = findNearestElevator(destinationFloor);
        return nearestElevator.getCurrentFloor();
    }

    private Elevator findNearestElevator(int floor) {
        Elevator nearestElevator = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearestElevator = elevator;
            }
        }
        return nearestElevator;
    }

    public void updateElevators() {
        for (Elevator elevator : elevators) {
            elevator.updatePosition();
        }
    }

    public void displayStatus() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = totalFloors - 1; i >= 0; i--) {
            StringBuilder floorDisplay = new StringBuilder("|");
            for (Elevator elevator : elevators) {
                char elevatorChar = elevator.getCurrentFloor() == i ? (char) ('A' + elevator.getId() - 1) : ' ';
                floorDisplay.append(elevatorChar).append(' ');
            }
            floorDisplay.append('|');
            System.out.println(floorDisplay);
        }
        System.out.println("=====");
    }
}
