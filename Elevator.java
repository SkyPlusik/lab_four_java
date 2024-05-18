public class Elevator {
    private int currentFloor;
    private int destinationFloor;
    private boolean movingUp;
    private int id;  // уникальный идентификатор лифта

    public Elevator(int id) {
        this.currentFloor = 0;
        this.destinationFloor = 0;
        this.movingUp = true;
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
        this.movingUp = destinationFloor > currentFloor;
    }

    public void updatePosition() {
        if (currentFloor < destinationFloor) {
            currentFloor++;
        } else if (currentFloor > destinationFloor) {
            currentFloor--;
        }
    }

    public boolean isAtRest() {
        return currentFloor == destinationFloor;
    }

    public int getId() {
        return id;
    }
}
