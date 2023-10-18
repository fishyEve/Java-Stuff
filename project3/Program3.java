// Name: Eve Collier
// evecollier3@gmail.com
// CSC 2290 Object Oriented Programming
// Date: March 21, 2022
// Desc:CSC 2290 Program 3: Mario Kart Tornument (part 2)


/*
    “I will practice academic and personal integrity and excellence of
character and expect the same from others.” 
As an academic community, Florida Southern College is firmly committed to 
honor and integrity in the pursuit of knowledge. Therefore, as a member
of this academic community, each student acknowledges  responsibility  for 
his  or  her  actions  and  commits  to  the  highest  standards  of integrity.  
In doing so through this Honor Code, each student makes a covenant with the
college  not to engage in any form of academic dishonesty, fraud, cheating, 
or theft.  Further information on the Honor Code is available in the
current Catalog.
     */
import java.util.*;

public class Program3 {
    // Here are some global variables that'll assist us throughout this program,
    // saved into an array for our convenience 
    public static String[] karts = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser", "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "BiddyBuggy", "Landship", "Sneeker", "Sports Coupe", "Gold Standard"};
    public static String[] bikes = {"Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike"};
    public static String[] ATVs = {"Standard ATV", "Wild Wiggler", "Teddy Buggy"};
    public static String[] chars = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad", "Koopa Troopa", "Daisy", "Shy Guy", "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy"};
    public static String[] tracks = {"Sunshine Airport", "Dolphin Shoals", "Electrodrome", "Mount Wario"};
    public static int[] recordTimes = {115, 117, 115, 100};
    public static boolean[] timeTrialPerformed = new boolean[4];
    // Also, we initalize another global to keep track of how many competitors  
    // performed a time trial. This is specifically done to calculate the 
    // average times for each track
    public static int competitorsDoneTimeTrials = 1;
    

    
    
    public static void displayMenu() {
        // Here we will merely display the menu to the user. Note that input
        // is NOT actually taken here, as this method just prints the menu
        System.out.print("\n---------------------------------------------------------------------\n"
                + "|                FSC eSports - Mario Kart Tournament                |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose from the following menu:                            |\n"
                + "|     1. Register a new competitor                                  |\n"
                + "|     2. Search for a competitor by ID number                       |\n"
                + "|     3. Search for a competitor by name                            |\n"
                + "|     4. Perform Time Trial                                         |\n"
                + "|     5. Display Leaderboard                                        |\n"
                + "|     6. Display all competitors                                    |\n"
                + "|     7. Display statistics                                         |\n"
                + "|     8. Erase all competitor times and reset Leaderboard           |\n"
                + "|     9. Quit                                                       |\n"
                + "---------------------------------------------------------------------\n"
                + "Enter your choice: ");
    } // END of displayMenu()
    
    

    public static int readAndVerifyChoice(Scanner in, int numChoices) {
        // Declare userChoice and userChoiceInt up here
        String userChoice; 
        int userChoiceInt;

        while (true) {
            // Uses a while loop to take user input
            userChoice = in.nextLine();
            // If the user choice has a length of one or two and is a digit,
            // it's valid, which means we can parse the user's choice as an int       
            if ((userChoice.length() == 1 || userChoice.length() == 2) && containsOnlyDigits(userChoice)) {
                userChoiceInt = Integer.parseInt(userChoice);
                // If the user's number is bigger than one AND is less than or
                // equal to the number of choices they have, their number choice
                // can be returned to them
                if (userChoiceInt >= 1 && userChoiceInt <= numChoices) {
                    return userChoiceInt;
                }
                // ELSE, the user choice is not a valid choice, and an 
                // appropriate error message needs to be displayed to them
                else {
                    System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                    System.out.println("Please try again.\n");
                    System.out.print("Enter your choice: ");
                }
            }
            // ELSE, the user choice is not valid, once again, an error needs to
            // be displayed
            else {
                System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                System.out.println("Please try again.\n");
                System.out.print("Enter your choice: ");
            }
        }
    } //END of readAndVerifyChoice()
    
    
    

    public static int readAndVerifyID(Scanner in) {
        // This method reads and verifies an inputted user ID to make sure it's
        // valid.
        
        // We can start by declaring an ID
        String id;

        while (true) {
            // A while loop is used to take user input
            id = in.nextLine();
            
            // IF the inputted user ID is seven characters long and contains 
            // nothing but digits, it is valid, and we can parse their inputted
            // ID
            if (id.length() == 7 && containsOnlyDigits(id) == true) {
                return Integer.parseInt(id);
            }
            // ELSE, the inputted user ID is not valid and an appropriate 
            // error message needs to be displayed to the user
            else {
                System.out.println("\nInvalid entry. Please try again.\n");
                System.out.print("Enter the ID of the competitor: ");
            }
        }
    } //END of readAndVerifyID()
    
    

    public static boolean containsOnlyDigits(String s) {
        // This method simply checks to make sure if a given string contains 
        // only digits
        for (int i = 0; i < s.length(); i++) {
            // This for loop goes through each character in a given string
            // then checks whether not the character at index i is a digit or
            // not. If it is not a digit, false is returned.
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        // And if the character at index i IS a digit, true is returned
        return true;
    } //END of containsOnlyDigits()
    
    
    

    public static boolean containsOnlyNameChars(String s) {
        // This methoc checks to see if a given string contains ONLY letters
        
        // We start by declaring character c
        char c;

        for (int i = 0; i < s.length(); i++) {
            // A for loop is used to loop through each character of a given 
            // string
            
            // c is the current index i is at in the given string
            c = s.charAt(i);
            // IF the character at i isn't a letter, space, or dash, false
            // will be returned
            if (!(Character.isLetter(c) || c == ' ' || c == '-')) {
                return false;
            }
        }
        // If we get to this point, the character at index i is either a letter,
        // space, or dash, which means true can be returned
        return true;
    } // END of containsOnlyNameChars()
    
    
    

    public static String readAndVerifyName(Scanner in, String type) {
        // This method reads names inputted by the user and checks to see if 
        // they're valid.
        
        // This is started by declaring name
        String name;

        while (true) {
            // User input is taken via a while loop
            name = in.nextLine();
            
            // If the name length is greater than one AND less than 21, and
            // contains only letters, spaces, or dashes, then we can return the
            // name, as it's valid
            if (name.length() > 1 && name.length() < 21 && containsOnlyNameChars(name)) {
                return name;
            }
            // ELSE, the name is not valid, and an appropriate error message
            // must be displayed to the user
            else {
                System.out.println("\nInvalid entry. Name must be between 2 and 20 characters and");
                System.out.println("may only contain letters, spaces, or dashes. Please try again.\n");
                System.out.printf("Enter the %s name of the competitor: ", type);
            }
        }
    } // END of readAndVerifyName()
    
    
    

    public static String selectVehicle(Scanner in) {
        // This method allows a user to make their vehicle selection when 
        // registering a competitor
        
        // We can start by declaring the category and vehicle selection
        int category, vehicleSelection;

        // The vehicle category menu is displayed to the user....
        System.out.print("\n---------------------------------------------------------------------\n"
                + "|                         Vehicle Category                          |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose your category of vehicle:                           |\n"
                + "|     1. Kart                                                       |\n"
                + "|     2. Bike                                                       |\n"
                + "|     3. ATV                                                        |\n"
                + "---------------------------------------------------------------------\n"
                + "Enter your choice: ");
        // THEN we take their input as to WHICH vehicle they choose, verify it,
        // then based off of their choice, the user is taken to another menu
        category = readAndVerifyChoice(in, 3);

        switch (category) {
            // If the user chose choice 1...they need the kart selection menu
            case 1:
                // Here we display the kart menu to the user
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          Kart Selection                           |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your Kart:                                          |");
                for (int i = 0; i < karts.length; i++) {
                    // Instead of typing out the entire kart selection menu, 
                    // this for loop goes through and loops through each 
                    // kart in the global karts variable, then prints it to the
                    // user.
                    // Looks kinda crazy. This is crazy cool starter code.
                   
                    System.out.printf("|     %-4s%-58s|\n", (i + 1) + ".", karts[i]);
                }
                // This line is part of the menu, don't worry about it :)
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                // Vehicle selection is set equal to the user's kart input,
                // then their selection is returned to them, subtracted by one
                // because the karts values start at 0
                vehicleSelection = readAndVerifyChoice(in, karts.length);
                return karts[vehicleSelection - 1];
            case 2:
                // If the user chose choice 2...they need the bike selection 
                // menu
                
                // Here we display the bike selection menu to the user
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          Bike Selection                           |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your Bike:                                          |");
                for (int i = 0; i < bikes.length; i++) {
                    // Once again, a for loop is used to print each bike to 
                    // the user instead of typing it all out
                    System.out.printf("|     %-3s%-59s|\n", (i + 1) + ".", bikes[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                // The user's choice is saved into vehicle selection once it's
                // verified, then returned, subtracted by one because, again,
                // the bikes values start at 0
                vehicleSelection = readAndVerifyChoice(in, bikes.length);
                return bikes[vehicleSelection - 1];
            default:
                // AND NOW, if the user chose 3...they need the ATV menu
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          ATV Selection                            |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your ATV:                                           |");
                for (int i = 0; i < ATVs.length; i++) {
                        // Once again, a for loop is used to go through each 
                        // of the ATVs instead of typing the whole menu out
                    System.out.printf("|     %-3s%-59s|\n", (i + 1) + ".", ATVs[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                // The user input is saved into vehicle selection after it's
                // verified, and we return the value minus one because, you 
                // guessed it, the ATV values start at 0
                vehicleSelection = readAndVerifyChoice(in, ATVs.length);
                return ATVs[vehicleSelection - 1];
        }
    } // END of selectVehicle()
    
    
    
    

    public static String selectCharacter(Scanner in) {
        // This method allows the user to select their character when 
        // registering a new competitor
        
        // We start by declaring characterSelection
        int characterSelection;

        // The character selection menu is displayed to the user
        System.out.println("\n---------------------------------------------------------------------\n"
                + "|                        Character Selection                        |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose your character:                                     |");
        for (int i = 0; i < chars.length; i++) {
            // A for loop is used to loop through each character instead of
            // manually typing out each character
            System.out.printf("|     %-4s%-58s|\n", (i + 1) + ".", chars[i]);
        }
        System.out.print("---------------------------------------------------------------------\n"
                + "Enter your choice: ");
        // The user's character choice is saved into characterSelection after
        // it's verified, then their choice is returned after being subtracted
        // by one because, again, the values in chars start at 0
        characterSelection = readAndVerifyChoice(in, chars.length);
        return chars[characterSelection - 1];
    } // END of selectCharacter()
    
    
    
    

    public static void registerCompetitor(Competitor[] competitors, Scanner in) {
        // This method allows the user to register a new competitor into the
        // system
        
        // First, we need to prompt the user to enter the ID of the competitor
        System.out.println("Enter the ID of the competitor: ");
        int userIDInput = readAndVerifyID(in);
        
        // The same needs to be done with the first name of the competitor
        System.out.println("Enter the first name of the competitor:");
        String userFirstNameInput = readAndVerifyName(in, "first");
        
        // And again with the last name
        System.out.println("Enter the last name of the competitor:");
        String userLastNameInput = readAndVerifyName(in, "last");
        
        // Now that we have those pieces of information, the character selection
        // screen can be displayed to the user, and the user should be able to
        // select their their character
        String userCharacter = selectCharacter(in);
        
        // After that, the user needs to select their vehicle
        
        String userVehicle = selectVehicle(in);
        
        // Make a new competitor object with everything the user just inputted 
        Competitor s = new Competitor (userIDInput, userFirstNameInput, userLastNameInput, userCharacter, userVehicle);

        
        // Now we need to figure out where to insert the competitor based on
        // their ID number- the competitor with the smallest ID number will be
        // at index 0, whereas the competitor with the largest ID number will
        // be stored at the highest index in the Competitor object refrence into
        // the array
        
        // First we can start by making an insert index that'll be edited later
        int insertIdx = 0;
        
        // Next, we need to enter a for loop to loop through each competitor in
        // the array, and we need to determine at which index the competitor
        // needs to be inserted into
        for (int i = 0; i < Competitor.getNumCompetitors()-1; i++) {      
            if (s.getId() > competitors[i].getId()){
                insertIdx++; 
            }
            else{
                break;
            }
        }
        // Now that we have the index in which this competitor needs to be
        // inserted into, every character that's held at higher indexes need
        // to be shifted one to the right as to make sure we don't overwrite 
        // any already registered competitors
        // We can do that by entering yet another for loop
        for (int i = Competitor.getNumCompetitors()-1; i >= insertIdx; i--) {
            competitors[i + 1] = competitors[i];  
        }
        competitors[insertIdx] = s;
  
        // At this point, the user has succsessfully registered their competitor
        // An appropriate message needs to be displayed informing the user of 
        // this
        System.out.println("You have successfully registered the following competitor:\n");
        // We do this by calling our toString() method
        System.out.println(s.toString());       

    } // END of registerCompetitor()
    
    

    public static void searchByID(Competitor[] competitors, Scanner in) {
        // This method allows the user to search for a specific competitor 
        // based off of their ID number 
        
        // First we need to prompt the user to enter the ID that they want to
        // search for a registered user with
        System.out.println("Enter the ID of the competitor");
        int userIDInput = readAndVerifyID(in);
        
        // Initalize a flag and set it to false, if we find the corresponding
        // ID in the array, the flag will be set to true
        boolean flag = false;
        
        
        // Now we need to enter a for loop to see if the entered ID matches that
        // of a registered competitor

        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            if (userIDInput ==  competitors[i].getId()){
                // If the inputted ID number matches one of the ID numbers in
                // competitors, set the flag to true, then print an appropriate
                // message to display the succsess to the user
                flag = true;
                System.out.println("Competitor was successfully found!"); 
                System.out.println(competitors[i].toString());
                break;
            } 
        }
        // If the flag is still false, that means the user entered a ID number
        // that does not exist. Print an appropriate message to signify the
        // user of that
        if (!flag){
                System.out.println("Competitor ID #" + userIDInput + " was not found in the system.");
            }
        

    } // END of searchBy ID()
    
    

    public static void searchByName(Competitor[] competitors, Scanner in) {
        // This method is very similar to searchByID(), except now we're 
        // searching to see whatever the user inputs is the same as a first
        // and last name of a registered competitor in the system.
        
        // Firstly, we need to prompt the user to enter a first and last name
        System.out.println("Enter the first name of the competitor:");
        String userFirstInput = readAndVerifyName(in, "first");
        
        System.out.println("Enter the last name of the competitor:");
        String userLastInput = readAndVerifyName(in, "last");
        
        // Initalize a flag and set it to false, if we find the corresponding
        // first and last name in the array, the flag will be set to true
        boolean flag = false;
        
        // We need to use a for loop to loop through each competitor and see if
        // the entered names match any names in the system
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            if (userFirstInput.equalsIgnoreCase(competitors[i].getFirstName())){
                if (userLastInput.equalsIgnoreCase(competitors[i].getLastName())){
                    // If the inputted first and last name match one in the 
                    // system, the flag can be set to true, and the 
                    // corresponding competitor information can be displayed to
                    // the user
                    flag = true;
                    System.out.println("Competitor was successfully found!");
                    System.out.println(competitors[i].toString());
                    break;
                }
            }   
        }
        // If the flag is false, that means a user with the first and last names
        // that the user entered does not exist, thus, an appropriate message
        // must be displayed to the user
        if(!flag){
            System.out.println("Competitor \"" + userFirstInput + " " + userLastInput + "\" was not found in the system.");
        }

    } // END of searchByName()
    
    

    public static void performTimeTrial(Competitor[] competitors, Scanner in, Random rng) {
        // This method will complete a time trial for every registered 
        // competitor with whichever track the user selects.
        
        // If there are no registered competitors, the time trials cannot take
        // place
        if (Competitor.getNumCompetitors() < 1){
            System.out.println("Time trials cannot take place, as there are no competitors");
            System.out.println("currently registered in the system.");
        }
        // ELSE if the number of competitors is not less than one, we have at 
        // least one registered competitor, which is enough to perform a time
        // trial
        else{
            // We need to start by displaying the track selection menu to the 
            // user
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                   Track Selection for Time Trial                  |");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("| Please select the track for the time trial:                       |");
            System.out.println("|     1. Sunshine Airport                                           |");
            System.out.println("|     2. Dolphin Shoals                                             |");
            System.out.println("|     3. Electrodrome                                               |");
            System.out.println("|     4. Mount Wario                                                |");
            System.out.println("---------------------------------------------------------------------");
            
            // Now that the menu is there, the user can make their selection
            System.out.println("Enter your choice: ");
            int trackInput = readAndVerifyChoice(in, 4);
            
            // userTrack is going to be initalized from the beginning
            String userTrack = "";

            
            
            // Firstly, we need to enter a for loop so that we can perform a 
            // time trial for each registered competitor
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // We need to keep track of how many people perform a time trial
                competitorsDoneTimeTrials = Competitor.getNumCompetitors();
                
                // We need 4 if statements, so we can perform a time trial based
                // off of whatever track the user selected to do a time trial
                // for
                if (trackInput == 1){
                    userTrack = tracks[0];
                    competitors[i].setBestTimes(0, recordTimes[0] + rng.nextInt(30));
                }
                
                if (trackInput == 2){
                    userTrack = tracks[1];
                    competitors[i].setBestTimes(1, recordTimes[1] + rng.nextInt(30));
                }
                
                if (trackInput == 3){
                    userTrack = tracks[2];
                    competitors[i].setBestTimes(2, recordTimes[2] + rng.nextInt(30));
                }
                
                if (trackInput == 4){
                    userTrack = tracks[3];
                    competitors[i].setBestTimes(3, recordTimes[3] + rng.nextInt(30));
                } 
            }
            // At this point, new time trials have been recorded for whichever
            // track the user selected. An appropriate message needs to be 
            // displayed to notify the user of that
            System.out.println("All competitors have new times recorded for " + userTrack);         
        }

    } // END of performTimeTrial()
    
    

    public static void displayLeaderBoard(Competitor[] competitors) {
        // This method will determine and display the best recorded times for 
        // each of the four tracks to the user. If more than one competitor has 
        // the best time, each will be printed. If a track has no time recorded,
        // an appropriate message will print, informing the user of that

        // To do this, we simply need to find the shortest race time in each 
        // column, then display those times as well as the corresponding 
        // competitor to the user
        
        // These need to be initalized here to help later
        int seconds = 0;
        int minutes2 = 0;
        int minutes = 0;
        
        // We'll start by initalizing a min aarray named minTime- this will 
        // store each best time for each track.
        int[] minTime = new int[tracks.length];
        
        // Set EVERY value in minTime to the max value
        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        // We'll also make an array to save the corresponding user info
        int[] userInfo = new int[tracks.length];
        
        // We need to use a for loop to loop over each track and then pull
        // the fastest time from said track
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            // We need to loop through each times at the specific track
            // and then pull the smallest value from the set of times from
            // said track
            for (int j = 0; j < competitors[i].getBestTimes().length; j++) {
                if (minTime[j] > competitors[i].getBestTimes()[j]) {
                    // check if competitor even has a recorded time
                    if (competitors[i].getBestTimes()[j] != 0){
                        minTime[j] = competitors[i].getBestTimes()[j];
                        userInfo[j] = i;
                        
                    }
                    
                }
            }
        }
        // With that done, we are now able to physically display the leaderboard
        // to the user      
        System.out.println("");
        System.out.println("Leaderboard: ");
        // To do this, we need to enter a for loop to display each value in 
        // minTime
        for (int k = 0; k < minTime.length; k++) {
            // If the index at midTime is equal to the min value, that means that
            // nothing was added to that index of midTime- therefore- there was
            // no time recorded for that particular track.
            if (minTime[k] == Integer.MAX_VALUE) {
                System.out.println("   " + tracks[k]);
                System.out.println("      no time trials recorded");
            }
            // ELSE, there is a valid high score found for that track and it can
            // be displayed for the user
            else{
                Competitor best = competitors[userInfo[k]];
                System.out.println("   " + tracks[k]);                            
                System.out.println(best.getFirstName() + " " + best.getLastName() + "(ID: " + best.getId() + ")");
                System.out.println("Character: " + best.getCharacter());
                System.out.println("Vehicle: " + best.getVehicle());
                // And now for formatting time correctly. Fun
                
                // convert mins and seconds
                seconds = best.getBestTimes(k) % 60;
                minutes2 = best.getBestTimes(k) / 60;
                minutes = minutes2 % 60;
                // We need to see if the seconds is two-digit or one-digit,
                // if one-digit, a zero needs to be added in front of the
                // number
                String Seconds = String.valueOf(seconds);
                if (Seconds.length() == 1) {
                    // If the seconds length is 1, we simply add a 0 in 
                    // front of the single number
                    System.out.println("Time: " + minutes + "'" + "0" + seconds + "\"");
                }
                // ELSE, we just print the two digit seconds number
                else {
                    System.out.println("Time: " + minutes + "'" + seconds + "\"");
                }
            }
        }  
    } // END of displayLeaderBoard()
     

    public static void displayAllCompetitors(Competitor[] competitors) {
        // This method will display all registered competitors. If there are
        // no registered competitors, an appropriate message will be displayed
        // to the user
        
        // We need to check the number of registered competitors. If there are
        // none, an appropriate message needs to be displayed to the user
        if (Competitor.getNumCompetitors() < 1){
            System.out.println("There are no competitors currently registered in the system.");
        }
        // ELSE if the count is NOT greater than 0, we can loop over each 
        // competitor and display their information to the user.
        else{
            System.out.println("Competitors registered in the system:");
            // We loop through each registered competitor, then print each
            // competitor's information using toString()
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                System.out.println(competitors[i].toString());  
                System.out.println("");
            }   
        }     

    } // END of displayAllCompetitors()
    
    

    public static void displayStatistics(Competitor[] competitors) {
        // This method will calculate the average time trial for each track
        // and then display that average to the user. If a track has no recorded
        // time trial, an appropriate message will be displayed to the user
        
        // These need to be initalized here to use later
        int seconds;
        int minutes;
        int minutes2;
        
        // IF there are no competitors, we cannot display any stats for the user
        if (Competitor.getNumCompetitors() < 1){
            System.out.println("There are no statistics recorded, as there are no");
            System.out.println("competitors currently registered in the system.");
        }
        // ELSE, there are registered competitors, and some statistics can be
        // displayed to the user
        else{
            // We also need to define this here, this array will store each
            // average of each track
            int [] average = new int [tracks.length];  
            
            // We need to loop over each competitor, and then go through each
            // track and retrieve all competitor's times for said track
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                for (int j = 0; j < competitors[i].getBestTimes().length; j++) {
                    // We'll start calculating the average by
                    // summing the times for every track
                    average[j] += competitors[i].getBestTimes()[j];
                    
                }
            }
            // After we've gotten each time for each track added into our 
            // average array...
            // These will hold the average for EACH track
            average[0] = average[0] / competitorsDoneTimeTrials;  
            average[1] = average[1] / competitorsDoneTimeTrials; 
            average[2] = average[2] / competitorsDoneTimeTrials; 
            average[3] = average[3] / competitorsDoneTimeTrials; 
            
            System.out.println("Statistics of Completed Time Trials - Average Time per Track");
            // Now we need to display the average to the user          
            for (int k = 0; k < average.length; k++){
                // IF there is no time recorded at the specific index in our
                // averages
                if (average[k] == 0){
                    System.out.println("    " + tracks[k] + ": " + "   no time trials recorded");
                }
                // ELSE  if there is a found time at the specific index in our 
                // averages
                else {
                    // convert mins and seconds
                    seconds = average[k] % 60;
                    minutes2 = average[k] / 60;
                    minutes = minutes2 % 60;
                    // We need to see if the seconds is two-digit or one-digit,
                    // if one-digit, a zero needs to be added in front of the
                    // number
                    String Seconds = String.valueOf(seconds);
                    if (Seconds.length() == 1) {
                        // If the seconds length is 1, we simply add a 0 in 
                        // front of the single number
                        System.out.println("    " + tracks[k] + ": " + minutes + "'" + "0" + seconds + "\"");

                    }
                    // ELSE, we just print the two digit seconds number
                    else {
                        System.out.println("    " + tracks[k] + ": " + minutes + "'" + seconds + "\"");

                    }
                }
            }
        }
    } // END of displayStatistics()
    
    

    public static void eraseAndReset(Competitor[] competitors) {
        // This method will go through and erase each saved time for each
        // competitor
        
        // To do this, we will enter a for loop that will loop through each
        // competitor and set each of their times for each track to 0
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            competitors[i].setBestTimes(0, 0);
            competitors[i].setBestTimes(1, 0);
            competitors[i].setBestTimes(2, 0);
            competitors[i].setBestTimes(3, 0);             
        } 
        // Now, we need to print a statement that tells the user that all 
        // competitor's times been erased
        System.out.println("All competitors times have been cleared, and the Leaderboard has been reset.");

    } // END of eraseAndReset()
   
       

    public static void main(String[] args) {
        // Variables used in program
        Scanner in = new Scanner(System.in);
        Random rng;               // Random Number Generator
        int maxCompetitors;       // value read from user and used to create arrays
        int seed;                 // value read from user and used to seed the RNG
        int userChoice;           // value read from user as their main menu selection
        Competitor[] competitors; // array to store the competitor object references

        // Scan seed used for random
        System.out.print("Enter the seed for the random number generator: ");
        seed = Integer.parseInt(in.nextLine());
        rng = new Random(seed);

        // Scan max number of competitors
        System.out.print("Enter the maximum number of competitors: ");
        maxCompetitors = Integer.parseInt(in.nextLine());

        // Create the new array of Competitor references
        competitors = new Competitor[maxCompetitors];
        // This is an array of Competitor object REFERENCES
        // Each reference currently points to "null" (no objects have been created yet)

        OUTER:
        while (true) {
            displayMenu();
            userChoice = readAndVerifyChoice(in, 9);
            switch (userChoice) {
                case 1:
                    registerCompetitor(competitors, in);
                    break;
                case 2:
                    searchByID(competitors, in);
                    break;
                case 3:
                    searchByName(competitors, in);
                    break;
                case 4:
                    performTimeTrial(competitors, in, rng);
                    break;
                case 5:
                    displayLeaderBoard(competitors);
                    break;
                case 6:
                    displayAllCompetitors(competitors);
                    break;
                case 7:
                    displayStatistics(competitors);
                    break;
                case 8:
                    eraseAndReset(competitors);
                    break;
                default:
                    // if (userChoice == 8) {
                    System.out.println("\nGoodbye!");
                    break OUTER;
            } // END switch
        } // END while (true)
    } // END main()
}
