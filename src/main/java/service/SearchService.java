package service;

import model.Bid;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchService {

  private List<Vehicle> vehicles;

  Scanner in = new Scanner(System.in);

  public SearchService(MockDataSource mockDataSource) {
    vehicles = mockDataSource.getVehicles();
  }

  List<Vehicle> getVehiclesByMake(String make) {
    return vehicles.stream().filter(v -> v.getMake().equals(make)).collect(Collectors.toList());
  }

  List<Vehicle> getVehiclesByModel(String model) {
    return vehicles.stream().filter(v -> v.getModel().equals(model)).collect(Collectors.toList());
  }

  Vehicle getVechicleById(String id) {
    Optional<Vehicle> vehicle = vehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
    if (vehicle.isPresent()) {
      return vehicle.get();
    }
    return null;
  }

  List<Vehicle> getVehiclesByYear(String minimumYear) {
    try {
      return vehicles.stream().filter(v -> Integer.parseInt(v.getYear()) >= Integer.parseInt(minimumYear)).collect(Collectors.toList());
    } catch (NumberFormatException e) {
      return new ArrayList<>();
    }
  }

  List<Vehicle> getVehiclesByMileage(String mileage) {
    try {
      return vehicles.stream().filter(v -> Integer.parseInt(v.getMileage()) <= Integer.parseInt(mileage)).collect(Collectors.toList());
    } catch (NumberFormatException e) {
      return new ArrayList<>();
    }
  }

  public void searchMenu() {
    boolean quit = false;
    int menuItem;

    do {
      printMenu();
      menuItem = in.nextInt();

      switch (menuItem) {
        case 1:
          displayAll();
          break;
        case 2:
          displayByMake();
          break;
        case 3:
          displayByModel();
          break;
        case 4:
          displayByYear();
          break;
        case 5:
          displayByMileage();
          break;
        case 6:
          quit = true;
          break;
        case 0:
          System.exit(0);
        default:
          System.out.println("Invalid choice.");
      }
    } while (!quit);
  }

  private void printMenu() {
    System.out.println("---------------------------------- \n" +
        "Search Vehicle Menu: \n" +
        "1. See All Vehicles \n" +
        "2. Search By Make \n" +
        "3. Search By Model \n" +
        "4. Search By Minimum Year \n" +
        "5. Search By Maximum Mileage \n" +
        "6. Back to Main Menu \n" +
        "0. Exit");
  }

  private void displayByMake() {
    System.out.println("Enter Car Make/Manufacturer: ");
    String manufacturer = in.next();
    List<Vehicle> vehicles = getVehiclesByMake(manufacturer);
    if (vehicles.size() == 0) {
      System.out.print("No Cars matching that make \n");
    } else {
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle.toString());
      }
      makeBid();
    }
  }

  private void displayByModel() {
    System.out.println("Enter Car Model: ");
    String model = in.next();
    List<Vehicle> vehicles = getVehiclesByModel(model);
    if (vehicles.size() == 0) {
      System.out.print("No Cars matching that model \n");
    } else {
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle.toString());
      }
      makeBid();
    }
  }

  private void displayByMileage() {
    System.out.println("Enter Maximum Mileage: ");
    String mileage = in.next();
    List<Vehicle> vehicles = getVehiclesByMileage(mileage);
    if (vehicles.size() == 0) {
      System.out.print("No Cars matching that mileage \n");
    } else {
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle.toString());
      }
      makeBid();
    }
  }

  private void displayByYear() {
    System.out.println("Enter Minimum Year: ");
    String year = in.next();
    List<Vehicle> vehicles = getVehiclesByYear(year);
    if (vehicles.size() == 0) {
      System.out.print("No Cars matching that year \n");
    } else {
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle.toString());
      }
      makeBid();
    }
  }

  private void displayAll() {
    for (Vehicle vehicle : vehicles) {
      System.out.println(vehicle.toString());
    }
    makeBid();
  }

  private void makeBid() {
    System.out.println("\n To select a vehicle to bid for, enter Catalogue Number");
    int catalogueNumber = in.nextInt();
    if (catalogueNumber > vehicles.size()) {
      System.out.println("Invalid Catalogue Number");
      return;
    }
    Vehicle vehicle = getVechicleById(Integer.toString(catalogueNumber));
    System.out.println(vehicle.toString());
    System.out.println("\n Your Bid:");

    String bid = in.next();
    Double bidValue = 0d;

    try {
      bidValue = Double.parseDouble(bid);
    } catch (NumberFormatException e) {
      System.out.println("Invalid Value");
      return;
    }


    if (bidValue > vehicle.getHighestBidValue()) {
      getVechicleById(Integer.toString(catalogueNumber)).addBid(new Bid("1", bidValue));
    } else {
      System.out.print("Bid Rejected, must be more than current highest bid \n");
    }
  }
}
