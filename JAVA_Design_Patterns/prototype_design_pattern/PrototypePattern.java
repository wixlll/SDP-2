package prototype_design_pattern; // Package declaration

import java.util.ArrayList;
import java.util.List;

// Prototype class that implements Cloneable
class Vehicle implements Cloneable {
  private List<String> vehicleList;

  public Vehicle() {
    this.vehicleList = new ArrayList<String>();
  }

  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }

  public void insertData() {
    // Initialize the list with sample vehicle names
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList() {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();

    for (String s : this.getVehicleList()) {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePattern {
  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle a = new Vehicle();
    a.insertData();

    Vehicle b = (Vehicle) a.clone(); // Clone the 'a' object
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze"); // Modify the cloned list

    System.out.println(a.getVehicleList()); // Print the original list from 'a'
    System.out.println(list); // Print the modified list from 'b'

    b.getVehicleList().remove("Audi A4"); // Remove an item from the cloned list
    System.out.println(list); // Print the modified list from 'b' again
    System.out.println(a.getVehicleList()); // Print the original list from 'a' (unaffected by changes)
  }
}
