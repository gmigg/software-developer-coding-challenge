package service;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import model.Bid;
import model.User;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MockDataSource {

  List<Vehicle> vehicles = generateVehicleCatalogue();
  List<User> users = generateUsers();

  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  public List<User> getUsers() {
    return users;
  }

  List<Vehicle> generateVehicleCatalogue(){
    List<Vehicle> catalogue = new ArrayList<Vehicle>();

    Vehicle vehicle1 = new Vehicle("1","Honda", "Civic", "2016", "15000");
    Vehicle vehicle2 = new Vehicle("2","Ford", "Focus", "2017", "10000");
    Vehicle vehicle3 = new Vehicle("3","Toyota", "Yaris", "2018", "8000");
    Vehicle vehicle4 = new Vehicle("4","Toyota", "Corolla", "2016", "14000");

    Bid bid1 = new Bid("1", 10000d);
    Bid bid2 = new Bid("2", 18000d);

    Bid bid3 = new Bid("2", 2000d);
    Bid bid4 = new Bid("2", 4000d);
    Bid bid5 = new Bid("3", 5000d);

    Bid bid6 = new Bid("4", 3200d);

    vehicle1.addBid(bid1);
    vehicle1.addBid(bid2);
    vehicle2.addBid(bid3);
    vehicle2.addBid(bid4);
    vehicle2.addBid(bid5);
    vehicle3.addBid(bid6);

    catalogue.add(vehicle1);
    catalogue.add(vehicle2);
    catalogue.add(vehicle3);
    catalogue.add(vehicle4);

    return catalogue;
  }

  List<User> generateUsers(){
    List<User> users = new ArrayList<>();
    User user1 = new User("1", "JJ");
    User user2 = new User("2", "OK");
    User user3 = new User("3", "PM");
    User user4 = new User("4", "GD");

    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);

    return users;
  }

}
