package service;

import model.User;
import model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class MockDataSourceTests {

  MockDataSource mockDataSource = new MockDataSource();

  @Test
  public void generateCatalogueLoadsAllData() {
    List<Vehicle> catalogue = mockDataSource.generateVehicleCatalogue();

    assert(catalogue.size() == 4);

    assert(catalogue.get(0).getBids().size() == 2);

    assert(catalogue.get(3).getBids().size() == 0);
  }

  @Test
  public void generateUsersLoadsAllUsers() {
    List<User> users = mockDataSource.generateUsers();

    assert(users.size() == 4);
    assert(users.get(0).getUserName().equals("JJ"));
    assert(users.get(3).getUserName().equals("GD"));

  }

}
