package builder_design_pattern; // Package declaration

class Vehicle {
  private String engine;
  private int wheel;
  private int airbags;

  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return this.wheel;
  }

  public int getAirbags() {
    return this.airbags;
  }

  // Private constructor that takes a VehicleBuilder
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }

  // Static nested class for building Vehicle objects
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    private int airbags;

    // Constructor to set required fields
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    // Method to set optional field (airbags) and return the builder
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    // Build and return a Vehicle instance using the builder
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern {
  public static void main(String[] args) {
    // Create a car using the VehicleBuilder
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    // Create a bike using the VehicleBuilder
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Print car details
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    // Print bike details
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
