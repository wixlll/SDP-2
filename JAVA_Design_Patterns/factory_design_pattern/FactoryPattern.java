package factory_design_pattern; // Package declaration

// Abstract class representing a vehicle
abstract class Vehicle {
	public abstract int getWheel(); // Abstract method to get the number of wheels
	public String toString() {
		return "Wheel: " + this.getWheel(); // Default toString method to display wheel count
	}
}

// Concrete class for Car, extends Vehicle
class Car extends Vehicle {
	int wheel;

	Car(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Concrete class for Bike, extends Vehicle
class Bike extends Vehicle {
	int wheel;

	Bike(int wheel) {
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

// Factory class for creating Vehicle objects
class VehicleFactory {
	public static Vehicle getInstance(String type, int wheel) {
		if (type.equals("car")) {
			return new Car(wheel); // Create and return a Car
		} else if (type.equals("bike")) {
			return new Bike(wheel); // Create and return a Bike
		}
		return null; // Return null if the type is not recognized
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		// Create a Car instance using the Factory
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		// Create a Bike instance using the Factory
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
