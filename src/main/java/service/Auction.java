package service;
import java.util.Scanner;

public class Auction {

  public static void main(String[] args) {

    MockDataSource mockDataSource = new MockDataSource();
    SearchService searchService = new SearchService(mockDataSource);
    Scanner in = new Scanner(System.in);
    boolean quit = false;
    int menuItem;

    do {
      System.out.print("Choose menu item:  \n 1. Search Vehicles \n 2. Quit");
      menuItem = in.nextInt();

      switch (menuItem) {
        case 1:
          System.out.println("Search Menu");
          searchService.searchMenu();
          break;
        case 2:
          quit = true;
          break;
        default:
          System.out.println("Invalid choice.");
      }

    } while (!quit);

    System.out.println("Logged Out");

  }

}




