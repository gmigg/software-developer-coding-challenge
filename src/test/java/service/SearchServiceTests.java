package service;


import model.Vehicle;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SearchServiceTests {

  MockDataSource mockDataSource = new MockDataSource();
  SearchService searchService = new SearchService(mockDataSource);

  @Test
  public void shouldReturnResultsByMakeIfVehiclesMatch(){
    List<Vehicle> vehicles = searchService.getVehiclesByMake("Toyota");

    assert(vehicles.size() == 2);
    assert(vehicles.get(0).getMake().equals("Toyota"));
    assert(vehicles.get(1).getMake().equals("Toyota"));
  }

  @Test
  public void shouldReturnEmptyListIfNoVehiclesMatchMake(){
    List<Vehicle> vehicles = searchService.getVehiclesByMake("Opel");

    assert (vehicles.size() == 0);
  }

  @Test
  public void shouldReturnResultsByModelIfVehiclesMatch(){
    List<Vehicle> vehicles = searchService.getVehiclesByModel("Focus");

    assert(vehicles.size() == 1);
    assert(vehicles.get(0).getModel().equals("Focus"));
  }

  @Test
  public void shouldReturnEmptyListIfNoVehiclesMatchModel(){
    List<Vehicle> vehicles = searchService.getVehiclesByModel("Astra");

    assert (vehicles.size() == 0);
  }

  @Test
  public void shouldReturnResultsIfVehiclesMatchMinimumYear(){
    List<Vehicle> vehicles = searchService.getVehiclesByYear("2014");

    assert(vehicles.size() == 4);
  }

  @Test
  public void shouldReturnEmptyListIfNoVehiclesMatchMinimumYear(){
    List<Vehicle> vehicles = searchService.getVehiclesByYear("2019");

    assert (vehicles.size() == 0);
  }

  @Test
  public void shouldReturnResultsIfVehiclesMatchMaxMileage(){
    List<Vehicle> vehicles = searchService.getVehiclesByMileage("10000");

    assert(vehicles.size() == 2);
  }

  @Test
  public void shouldReturnEmptyListIfNoVehiclesMatchMaxMileage(){
    List<Vehicle> vehicles = searchService.getVehiclesByMileage("3000");

    assert (vehicles.size() == 0);
  }

  @Test
  public void shouldReturnVehicleIfCatalogueIdMatches(){
    Vehicle vehicle = searchService.getVechicleById("1");

    assert (vehicle.getId() == "1");
    assert (vehicle.getMake() == "Honda");
  }
  @Test
  public void shouldNotReturnAVehicleIfNoCatalogueIdMatches(){
    Vehicle vehicle = searchService.getVechicleById("5");

    assert (vehicle == null);
  }







}
