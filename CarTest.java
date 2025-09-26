import java.util.Scanner;

abstract class Car {
    abstract String getMileage();
    abstract boolean getIsSedan();
    abstract int getSeats();
}

class WagonR extends Car {
    int mileage;
    WagonR(int mileage) { this.mileage = mileage; }
    String getMileage() { return mileage + " kmpl"; }
    boolean getIsSedan() { return false; }
    int getSeats() { return 4; }
}

class HondaCity extends Car {
    int mileage;
    HondaCity(int mileage) { this.mileage = mileage; }
    String getMileage() { return mileage + " kmpl"; }
    boolean getIsSedan() { return true; }
    int getSeats() { return 4; }
}

class InnovaCrysta extends Car {
    int mileage;
    InnovaCrysta(int mileage) { this.mileage = mileage; }
    String getMileage() { return mileage + " kmpl"; }
    boolean getIsSedan() { return false; }
    int getSeats() { return 6; }
}

public class CarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        int mileage = sc.nextInt();
        Car car;
        if (type == 0) car = new WagonR(mileage);
        else if (type == 1) car = new HondaCity(mileage);
        else car = new InnovaCrysta(mileage);

        System.out.println("Is Sedan: " + car.getIsSedan());
        System.out.println("Seats: " + car.getSeats());
        System.out.println("Mileage: " + car.getMileage());
    }
}
