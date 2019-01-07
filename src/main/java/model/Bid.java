package model;

public class Bid {

  private String bidderId;
  private Double amount;

  public Bid(String bidderId, Double amount){
    this.bidderId = bidderId;
    this.amount = amount;
  }

  public String getBidderId() {
    return bidderId;
  }

  public void setBidderId(String bidderId) {
    this.bidderId = bidderId;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getAmount(){
    return amount;
  }


}
