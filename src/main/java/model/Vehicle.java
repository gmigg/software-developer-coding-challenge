package model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {

  private String id;
  private String make;
  private String model;
  private String year;
  private String mileage;
  private List<Bid> bids;
  private Boolean active;

  public Vehicle(String id, String make, String model, String year, String mileage){
    this.id = id;
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public String toString(){
    return "\n--------------------------------------- \n" +
        "Catalogue Id: " + getId() + "\n" +
        "Make: " + getMake() + "\n" +
        "Model: " + getModel() + "\n" +
        "Year: " + getYear() + "\n" +
        "Mileage: " + getMileage() + "km \n" +
        "Current Highest Bid: " + getHighestBidValue() + "\n" +
        "Number of bids: " + getBids().size() + "\n";
  }

  public Bid getHighestBid(){
    return this.bids.get(bids.size() - 1);
  }

  public Double getHighestBidValue(){
    if(getBids().size() > 0){
      return getHighestBid().getAmount();
    }
    return 0d;
  }

}
