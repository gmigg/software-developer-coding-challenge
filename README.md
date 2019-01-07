# Software Developer Coding Challenge

This is a coding challenge for software developer applicants applying through http://work.traderev.com/

## Goal:

#### You have been tasked with building a simple online car auction system which will allow users to bid on cars for sale and with the following funcitionalies: 

  - [ ] Fork this repo. Keep it public until we have been able to review it.
  - [ ] A simple auction bidding system
  - [ ] Record a user's bid on a car
  - [ ] Get the current winning bid for a car
  - [ ] Get a car's bidding history 

 ### Bonus:

  - [ ] Unit Tests on the above functions
  - [ ] Develop a UI on web or mobile or CLI to showcase the above functionality

## Evaluation:

 - [ ] Solution compiles. Provide a README to run/build the project and explain anything that you leave aside
 - [ ] No crashes, bugs, compiler warnings
 - [ ] App operates as intended
 - [ ] Conforms to SOLID principles
 - [ ] Code is easily understood and communicative
 - [ ] Commit history is consistent, easy to follow and understand


### Auction
This is the main class. You run the application from here.
It is written wit the concept that as an application would grow, so to would features etc. So currently we have the bare bones which is the search service.

### SearchService Class:
Search has multiple options (Make, Model, Year and Mileage)
Bidding is currently managed from this spot in the application, as it is the clearest way currently to establish context about which item that you are bidding on
So I've surrounded the integer searches with a NumberFormatException in case it fails to parse if there are letters entered. This is the beginning of input validation.\

## Mock Data Source
The absence of real data for this application has led to the addition of this class.
This class adds 4 Vehicles, with differing numbers of bids on each. It also adds mock users, just for consistency, to mock the owners of bids.

##Models
The models with expansion in mind. For example, Vehicle rather than Car. Vehicle allows flexibility for sub-categorizing, either by enum types, of sub-classes if attributes differ.
The User and Bid are basic as possible at the moment.

##Note:
Obviously in a real world example this would be and API, that serves client Applications.
So I tried to make the search methods to be close to be what you would expect from a Service layer that would be called by a controller.

I added some Unit tests, probably could have added more coverage but testing void menu methods with scanners isn't very easy.
Given the primitive nature of Scanner, I will have missed some input validation. I'll try my best to catch crashables.

While I don't have a choice, I don't like that there is Scanners are Printlns everywhere. It makes for messy and unclean code. It also make methods more difficult to test which is antoher issue.

##Running
build: gradle build
run: Auction is the application class. Run Auction.main()