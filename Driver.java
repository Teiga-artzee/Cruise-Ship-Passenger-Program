import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


import static java.lang.Integer.parseInt;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();
    
    
    public static void main(String[] args) {

        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        
        //creates input for user
        Scanner input = new Scanner(System.in);
        
        Character userInput;
 
        do {
        	//Displays the menu after each do iteration
        	//Should user enter X or x, then program should exit
        	displayMenu();
        	
        	userInput = input.next().charAt(0);
        	if(userInput == '1') {
        		//Add Ship
        		addShip();
        	}
        	if(userInput == '2') {
        		//Edit Ship
        		editShip();
        	}
        	if(userInput == '3') {
        		//Add Cruise
            	addCruise();
        	}
        		
        	if(userInput == '4') {
        		//Edit Cruise
        		editCruise();
        	}
        	if(userInput == '5') {
        		//Add Passengers
        		addPassenger();
        	}
        	if(userInput == '6') {
        		//Edit passengers
        		editPassenger();
        	}
        	if((userInput == 'A')||(userInput == 'a')){
        		//Prints names of Ships
        		printShipList("name");
        	}
        	if((userInput == 'B')||(userInput == 'b')) {
        		//Prints Ship in Service List
        		printShipList("active");
        	}
        	if((userInput == 'C')||(userInput == 'c')) {
        		//Prints Ship Full List
        		printShipList("full");
        	}
        	if((userInput == 'D')||(userInput =='d')) {
        		//Prints Cruise List
        		printCruiseList("list");
        		System.out.print(cruiseList);
        	}
        	if((userInput == 'E')||(userInput == 'e')) {
        		//Prints cruiseList details
        		printCruiseList("details");
        	}
        	if((userInput == 'F')||(userInput =='f')) {
        		//Print passenger List
        		printPassengerList();
        	}
        	
        	
        } while((userInput != 'x')||(userInput != 'X'));
        
}

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
        
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView,
                           int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }


    public static void printShipList(String listType) {
        // printShipList() method prints list of ships from the
        // shipList ArrayList. There are three different outputs
        // based on the listType String parameter:
        // name - prints a list of ship names only
        // active - prints a list of ship names that are "in service"
        // full - prints tabbed data on all ships

        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships to print.");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        } else if (listType == "active") {
        	//prints all ships in service only
            System.out.println("\n\nSHIP LIST - Active");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                           Number of Rooms               IN      ");
            System.out.println("SHIP NAME           Bal  OV    Ste      Int            Service   ");
            System.out.println("-----------------------------------------------------------------");
            for (Ship inServiceShip: shipList)
            	if (inServiceShip.getInService() == true) {
                    inServiceShip.printShipData();
                	}
        } else if (listType == "full") {
        	//reformatted to match the active list and make it easier to read
        	//prints all ships in and out of service
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                           Number of Rooms               IN      ");
            System.out.println("SHIP NAME           Bal  OV    Ste      Int            Service   ");
            System.out.println("-----------------------------------------------------------------");
            for (Ship eachShip: shipList)
            	eachShip.printShipData();

        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises to print.");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        } else
            System.out.println("\n\nError: List type not defined.");
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    // Add a New Ship
    public static void addShip() {

    	//variables for creating Ship
        String nameShip = "NULL"; 
        Character userInput;
        int balconyNum, oceanViewNum, suiteNum, interiorNum;
        boolean inService = false;
        boolean newShipEntry = true;
    	Scanner shipInput = new Scanner(System.in);
    	
    	 //Boolean for wrong input
        boolean wrongInput = false;

    	//add Ship name
		
		do {
		System.out.println("Please enter the name of a new ship.");
		//Validate that name of ship is currently NOT in directory
		nameShip = shipInput.nextLine();
		if(shipList.contains(nameShip)) {
			newShipEntry = false;
			System.out.println("Please enter the name of a new ship.");
		}
		else {
			newShipEntry = true;
		}
		}while(newShipEntry != true);
		
		//input.nextLine allows for scanner object to recognize the new type of input
		//about to be used
		shipInput.nextLine();
		//add number of balcony rooms
		do {
		System.out.println("Please enter the number of balcony rooms.");
		if(shipInput.hasNextInt()) {
			wrongInput = false;
		}
		else {
			wrongInput = true;
			System.out.println("Wrong input. Please use digits.");
			System.out.println("Please enter the number of balcony rooms.");
		}
		balconyNum = shipInput.nextInt();
		}while(wrongInput != false);
		//add number of ocean view rooms
		do {
			System.out.println("Please enter the number of ocean view rooms.");
			if(shipInput.hasNextInt()) {
				wrongInput = false;
			}
			else {
				wrongInput = true;
				System.out.println("Wrong input. Please use digits.");
    			System.out.println("Please enter the number of ocean view rooms.");
			}
			oceanViewNum = shipInput.nextInt();	
		}while(wrongInput != false);
		//add number of suite rooms
		do {
			System.out.println("Please enter the number of suite rooms.");
			if(shipInput.hasNextInt()) {
				wrongInput = false;
			}
			else {
				wrongInput = true;
				System.out.println("Wrong input. Please use digits.");
    			System.out.println("Please enter the number of suite rooms.");
			}
			suiteNum = shipInput.nextInt();
		}while(wrongInput != false);
		//add number of interior rooms
		do {
			System.out.println("Please enter the number of interior rooms.");
			if(shipInput.hasNextInt()) {
				wrongInput = false;
			}
			else {
				wrongInput = true;
				System.out.println("Wrong input. Please use digits.");
    			System.out.println("Please enter the number of interior rooms.");
			}
			interiorNum = shipInput.nextInt();
		}while(wrongInput != false);
		//input.nextLine allows for scanner object to recognize the new type of input
		//about to be used
		shipInput.nextLine();
		//Check to see if ship is in service~correct input
		do {
			System.out.println("Is this ship currently in service?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			if(shipInput.hasNext()) {
				wrongInput = false;
			}
			else {
				wrongInput = true;
				System.out.println("Wrong input.");
				System.out.println("Is this ship currently in service?");
    			System.out.println("1. Yes");
    			System.out.println("2. No");
			}
			userInput = shipInput.next().charAt(0);
		}while(wrongInput != false);
		//check to see if ship in service true false set
		if(userInput == 1) {
			inService = true;
		}
		if(userInput == 2) {
			inService = false;
		}
		//Sends information to add ship method
		//variables in arguments should match up
		//if error, incorrect argument to parameter match ups
		//uses ship(args) in ship.java 
		//If further error, not all instances asked for
		//within code block
		add(nameShip, balconyNum, oceanViewNum, suiteNum, interiorNum, inService);

        //Create new Ship Object
    	Ship addShip = new Ship(nameShip, balconyNum, oceanViewNum, suiteNum, interiorNum, inService);
    	
    }

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    // Add a New Cruise
    public static void addCruise() {
    	
    	String cruiseName, departure, destination, returnPort, nameShip;
    	
    	Scanner cruiseInput = new Scanner(System.in);
    	System.out.println("Please enter the name of the ship.");
		
		nameShip = cruiseInput.nextLine();
		//add name of cruise ship is taking
		System.out.println("Please enter the name of the new cruise.");
		cruiseName = cruiseInput.nextLine();
		//add departure port
		System.out.println("Please enter the name of departure port.");
		departure = cruiseInput.nextLine();
		//add destination 
		System.out.println("Please enter the name of destination");
		destination = cruiseInput.nextLine();
		//add return port
		System.out.println("Please enter the name of return port.");
		returnPort = cruiseInput.nextLine();
		
		//Sends information to add cruise method
		//variables in arguments should match up
		//if error, incorrect argument to parameter match ups
		//uses cruise(args) in cruise.java 
		//If further error, not all instances asked for
		//within code block
    	Cruise newCruise = new Cruise(cruiseName, nameShip, departure, destination, returnPort);
    	
    }

    // Edit an existing cruise
    public static void editCruise() {

        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");

    }

    // Add a New Passenger
    public static void addPassenger() {

        Scanner newPassengerInput = new Scanner(System.in);
        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
            } else {
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false)
                return false;
        }
        return true;
    }

}