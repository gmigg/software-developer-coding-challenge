package model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
  String make;
  String model;
  String year;
  String mileage;
  List<Bid> bids;
  Boolean active;

  public Vehicle(String make, String model, String year, String mileage){
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.bids = new ArrayList<>();
    this.active = true ;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getMileage() {
    return mileage;
  }

  public void setMileage(String mileage) {
    this.mileage = mileage;
  }

  public List<Bid> getBids() {
    return bids;
  }

  public void setBids(List<Bid> bids) {
    this.bids = bids;
  }

  public void addBid(Bid bid) {
    this.bids.add(bid);
  }


  @Override
  public String toString(){
    return "--------------------------------------- \n" +
        "Make: " + make + "\n" +
        "Model: " + model + "\n" +
        "Year: " + year + "\n" +
        "Mileage: " + mileage + "\n" +
        "------------------------------------------\n" +
        "Current Highest Bid: " + getHighestBid().getAmount() + "\n" +
        "Number of bids: " + bids.size() ;
  }

  public Bid getHighestBid(){
    return this.bids.get(bids.size() - 1);
  }

}
