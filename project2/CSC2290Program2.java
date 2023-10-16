import java.util.*;

public class CSC2290Program2 {
// Eve Collier
// evecollier3@gmail.com
// CSC 2290 Object Oriented Programming
// Program 2: Mario Kart eSports Tournament

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

    // Here are some global variables that'll assist us throughout this program
    public static String [] karts = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser", "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "BiddyBuggy", "Landship", "Sneeker", "Sports Coupe", "Gold Standard"};
    public static String [] bikes = {"Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike"};
    public static String [] ATVs = {"Standard ATV","Wild Wiggler", "Teddy Buggy"};
    public static String [] characters = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad", "Koopa Troopa","Daisy", "Shy Guy", "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy"};
    public static String [] tracks = {"Sunshine Airport", "Dolphin Shoals", "Electrodrome", "Mount Wario"};
    public static int [] recordTimes = {115, 117, 115, 100};
    public static boolean [] timeTrialsPerformed = new boolean[4];
    // We also need to keep track of how many people performed a time trial
    public static int competitorsDoneTimeTrials = 1;

    
            

    
    public static void displayMenu() {
        // This method will simply display the menu to the user.
        // NOTE we are NOT taking user input here.
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                FSC eSports - Mario Kart Tournament                |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please choose from the following menu:                            |");
        System.out.println("|     1. Register a new competitor                                  |");
        System.out.println("|     2. Search for a competitor by ID number                       |");
        System.out.println("|     3. Search for a competitor by name                            |");
        System.out.println("|     4. Perform Time Trial                                         |");
        System.out.println("|     5. Display Leaderboard                                        |");
        System.out.println("|     6. Display all competitors                                    |");
        System.out.println("|     7. Display statistics                                         |");
        System.out.println("|     8. Quit                                                       |");
        System.out.println("---------------------------------------------------------------------");
        
    } //END of displayMenu()
    
    public static void displayCharacterMenu(){
        // This method will simply display the character selection menu to the 
        // user. NOTE we are NOT taking any input here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                        Character Selection                        |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please choose your character:                                     |");
        System.out.println("|     1.  Mario                                                     |");
        System.out.println("|     2.  Luigi                                                     |");
        System.out.println("|     3.  Peach                                                     |");
        System.out.println("|     4.  Yoshi                                                     |");
        System.out.println("|     5.  Bowser                                                    |");
        System.out.println("|     6.  Donkey Kong                                               |");
        System.out.println("|     7.  Toad                                                      |");
        System.out.println("|     8.  Koopa Troopa                                              |");
        System.out.println("|     9.  Daisy                                                     |");
        System.out.println("|     10. Shy Guy                                                   |");
        System.out.println("|     11. Wario                                                     |");
        System.out.println("|     12. Waluigi                                                   |");
        System.out.println("|     13. Baby Mario                                                |");
        System.out.println("|     14. Baby Luigi                                                |");
        System.out.println("|     15. Baby Peach                                                |");
        System.out.println("|     16. Baby Daisy                                                |");
        System.out.println("---------------------------------------------------------------------"); 
        
    } // END of displayCharacterMenu()
    
    public static void displayVehicleMenu() {
        // This method will simply display the vehicale selection menu to the 
        // user. NOTE we are NOT taking any input here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                         Vehicle Category                          |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please choose your category of vehicle:                           |");
        System.out.println("|     1. Kart                                                       |");
        System.out.println("|     2. Bike                                                       |");
        System.out.println("|     3. ATV                                                        |");
        System.out.println("---------------------------------------------------------------------");
        
    } // END of displayVehicleMenu()
    
    public static void kartSelectionMenu() {
        // This method will simply display the kart selection menu to the user.
        // NOTE we are NOT taking any input here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                          Kart Selection                           |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please choose your Kart:                                          |");
        System.out.println("|     1.  Standard Kart                                             |");
        System.out.println("|     2.  Pipe Frame                                                |");
        System.out.println("|     3.  Mach 8                                                    |");
        System.out.println("|     4.  Steel Driver                                              |");
        System.out.println("|     5.  Cat Cruiser                                               |");
        System.out.println("|     6.  Circuit Special                                           |");
        System.out.println("|     7.  Tri-Speeder                                               |");
        System.out.println("|     8.  Badwagon                                                  |");
        System.out.println("|     9.  Prancer                                                   |");
        System.out.println("|     10. BiddyBuggy                                                |");
        System.out.println("|     11. Landship                                                  |");
        System.out.println("|     12. Sneeker                                                   |");
        System.out.println("|     13. Sports Coupe                                              |");
        System.out.println("|     14. Gold Standard                                             |");
        System.out.println("---------------------------------------------------------------------");

    } // END of kartSelectionMenu()
    
    public static void bikeSelectionMenu() {
        // This method will simply display the bike selection menu to the user.
        // NOTE we are NOT taking any input here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                          Bike Selection                           |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please choose your Bike:                                          |");
        System.out.println("|     1. Standard Bike                                              |");
        System.out.println("|     2. Comet                                                      |");
        System.out.println("|     3. Sports Bike                                                |");
        System.out.println("|     4. The Duke                                                   |");
        System.out.println("|     5. Flame Rider                                                |");
        System.out.println("|     6. Varmint                                                    |");
        System.out.println("|     7. Mr. Scooty                                                 |");
        System.out.println("|     8. Jet Bike                                                   |");
        System.out.println("|     9. Yoshi Bike                                                 |");
        System.out.println("---------------------------------------------------------------------");
        
    } // END of bikeSelectionMenu()
    
    public static void atvSelectionMenu(){
        // This method will simply display the ATV selection menu to the user.
        // NOTE we are NOT taking any input here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                          ATV Selection                            |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please choose your ATV:                                           |");
        System.out.println("|     1. Standard ATV                                               |");
        System.out.println("|     2. Wild Wiggler                                               |");
        System.out.println("|     3. Teddy Buggy                                                |");
        System.out.println("---------------------------------------------------------------------");
        
    } // END of atvSelectionMenu()
    
    public static void trackSelectionMenu(){
        // This method will simply display the track selection menu to the user.
        // NOTE we are NOT taking any input here
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|                   Track Selection for Time Trial                  |");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Please select the track for the time trial:                       |");
        System.out.println("|     1. Sunshine Airport                                           |");
        System.out.println("|     2. Dolphin Shoals                                             |");
        System.out.println("|     3. Electrodrome                                               |");
        System.out.println("|     4. Mount Wario                                                |");
        System.out.println("---------------------------------------------------------------------");
        
    } // END of trackSelectionMenu()
    
    
    
    public static int readAndVerifyChoice(Scanner in, int numChoices ){
        // This method will scan the user's choice for the menu and make sure
        // it's 'legal', that meaning, it's equal to one of the numeric choices,
        // is actually a number, and so on. If it's not a legal choice, an 
        // error message will be displayed to the user
     

        // We will enter a loop to do this 
        while (true) {
            System.out.print("\nEnter your choice: ");
            String userNum = in.nextLine();
            
  
            // Next we have to make sure the input is a digit
            if (containsOnlyDigits(userNum)) {
                // If this passes, this means the input is a digit. Now we can
                // parse the input as an int
                int userNum2 = Integer.parseInt(userNum);
            
            
                // Next we need to make sure the user selected a number within
                // the choices avalible to them on the menu
                if (userNum2 <= numChoices && userNum2 > 0) {
                    return userNum2;
                }
            
                // If the if doesn't pass, that means the user selected a
                // number not avaliable                 
                else {
                    System.out.println("");
                    System.out.println("Invalid selection. Your choice must be a number between 1 and " + numChoices);
                    System.out.println("Please try again.");
                }
            }
            //If the user gets to this point, that means the user didn't put 
            // a number in
            else {
                System.out.println("");
                System.out.println("Invalid selection. Your choice must be a number between 1 and " + numChoices);
                System.out.println("Please try again.");
            }
        }

    } // END of readAndVerifyChoice()
    
    
    
    public static boolean containsOnlyDigits(String userInput) {
        // This method will check if string userInput contains only digits
        boolean onlyDigits = true;
        // Here we're simply initializing the boolean variable

        // This for loop will loop through each character of the string
        for (int i = 0; i < userInput.length(); i++) {
            // IF the character is a digit, it will set the onlyDigits boolean 
            // equal to true
            if (Character.isDigit(userInput.charAt(i))) {
                onlyDigits = true;
            }
            // On the other hand, if the character is NOT a digit, the 
            // onlyDigits boolean will be set equal to false
            else  {
                return false;
            }
        }
        // We exit the loop, then the onlyDigits boolean is returned
        return onlyDigits;

    } //END of containsOnlyDigits()
    
    
    
    public static boolean containsOnlyLettersSpacesOrDashes (String userInput){
        // This method will check if string userInput contains only letters,
        // spaces or dashes.
        
        boolean onlyLettersSpacesOrDashes = true;
        // Here we are simply initializing the boolean variable
        
        // In this for loop, we will loop through each character of the string
        for (int i = 0; i < userInput.length(); i++) {
            // If the character is a letter, the onlyLetterSpacesOrDashes bool
            // will be set to true
            if (Character.isLetter(userInput.charAt(i))){
                onlyLettersSpacesOrDashes = true;   
            }
            
            // If that if doesn't pass, we'll check to see if the user input
            // is a space
                
            else if (Character.isWhitespace(userInput.charAt(i))){
                onlyLettersSpacesOrDashes = true;
            }
            
            // and if THAT doesn't pass, let's check to see if the character
            // is a dash
            else if (userInput.charAt(i) == '-'){
                onlyLettersSpacesOrDashes = true;

            }
            
            // If NONE of those else ifs passed, userInput does NOT contain a 
            // letter, space, or dash.
            else{
                return false;
            }

        }
        // We exit the loop, and return onlyLettersSpacesOrDashes.
        return onlyLettersSpacesOrDashes;

    } // END of containsOnlyLettersSpacesOrDashes()
            
            
    
    
    public static int readAndVerifyID (Scanner in){
        // Much like readAndVerifyChoice(), this method is ALSO making sure
        // the user puts in a legal choice, except not for a menu. This method
        // ensure the user enters a legal ID 
        
        // We will enter a loop to do this
          
        
        while (true) {
            // First we need to actually get the user input
            System.out.print("\nEnter the ID of the competitor: ");
            String userID = in.nextLine();
           

            // If the user's input is longer than 7 characters, OR if it's 0
            // characters long, it'll tell the user that they made an invalid 
            // choice, and then let them enter their input again
            if (userID.length() != 7 || Integer.parseInt(userID) == 0) {
                System.out.println("");
                System.out.println("Invalid entry. Please try again.");
            }
            // Now we need to make sure the length of the user's input is equal
            // to seven- since that's the allowed length for an entered ID
            else if (userID.length() == 7){
                // NOW we need to make sure the input is a digit
                if (containsOnlyDigits(userID)){
                    // If this passed, that means the input is a digit, which 
                    // means the input can now be parsed into an int
                    int userID2 = Integer.parseInt(userID);
                    return userID2;
                }
                // If the if doesn't execute, that means that the user entered an
                // ID that was NOT a digit.
                else{
                    System.out.println("");
                    System.out.println("Invalid entry. Please try again.");
                }
                
   
            }
            // If the user gets to this point, it means their input wasn't
            // equal to the length of seven
            else{
                System.out.println("");
                System.out.println("Invalid entry. Please try again.");
            }
        }
        
 
    } // END of readAndVerifyID()
    
    public static String readAndVerifyName(Scanner in){
        // This method will read and make sure the user's name input is 'legal',
        // meaning that it adhears to the rules. The rules of a name input claim
        // that an inputted name must have a length of 2 and should contain 
        // ONLY letters, spaces, or dashes
        
        // We will enter a loop to check the user's first name
               
        
        while (true) {
            //First we need to actually get the user input
            System.out.print("\nEnter the first name of the competitor: ");
            String userFirstName = in.nextLine();
            userFirstName = userFirstName.replace(" ", "");

            // If the user's input is not loner than 2 characters, OR if it's 0
            // characters long, it'll tell the user that they made an invalid 
            // choice, and then let them enter their input again
            if (userFirstName.length() < 2){
                System.out.println("");
                System.out.println("Invalid entry. Name must be between 2 and 20 characters and");
                System.out.println("may only contain letters, spaces, or dashes. Please try again.");
            }
            // Now we need to make sure the length of the user's input is more
            // than two characters but less than 2-- since that's thats the 
            // minimum and maximum allowed characters
           else if (userFirstName.length() >= 2 && userFirstName.length() <= 20){
                // NOW we need to make sure the input is a letter, space, or
                // dash
                if (containsOnlyLettersSpacesOrDashes(userFirstName)){
                    // If this passed, that means the input is either a letter,
                    // space, or dash
                    return userFirstName;
                    

                }
                // If the if doesn't execute, that means that the user entered an
                // ID that was NOT longer than 2 characters.
                else{
                    System.out.println("");
                    System.out.println("Invalid entry. Name must be between 2 and 20 characters and");
                    System.out.println("may only contain letters, spaces, or dashes. Please try again.");
                }
                
            }
            
        
            // If the user gets to this point, it means their input wasn't
            // longer than two characters or less than 20
            
            else{
                System.out.println("");
                System.out.println("Invalid entry. Name must be between 2 and 20 characters and");
                System.out.println("may only contain letters, spaces, or dashes. Please try again.");
            }
            
        }
           
    } // END of readAndVerifyName()   
    
    
    
    public static String readAndVerifyLastName(Scanner in){
        
            // NOW we are ready for the last name
            // We will do exactly what we did in the first name method, but for
            // The last name. We need to verify the last name and make sure it's
            // 'legal'. To start, we will begin a while loop.
            
           
            while (true) {
            System.out.print("Enter the last name of the competitor: ");
            String userLastName = in.nextLine();
            userLastName = userLastName.replace(" ", "");

            // If the user's input is not loner than 2 characters, OR if it's 0
            // characters long, it'll tell the user that they made an invalid 
            // choice, and then let them enter their input again
            if (userLastName.length() < 2) {
                System.out.println("");
                System.out.println("Invalid entry. Name must be between 2 and 20 characters and");
                System.out.println("may only contain letters, spaces, or dashes. Please try again.");
                System.out.println("");
            }
            // Now we need to make sure the length of the user's input is more
            // than two characters but less than 2-- since that's thats the 
            // minimum and maximum allowed characters
            else if (userLastName.length() >= 2 && userLastName.length() <= 20){
                // NOW we need to make sure the input is a letter, space, or
                // dash
                if (containsOnlyLettersSpacesOrDashes(userLastName)){
                    // If this passed, that means the input is either a letter,
                    // space, or dash
                    
                    return userLastName;

                }
                // If the if doesn't execute, that means that the user entered an
                // ID that was NOT longer than 2 characters.
                else{
                    System.out.println("");
                    System.out.println("Invalid entry. Name must be between 2 and 20 characters and");
                    System.out.println("may only contain letters, spaces, or dashes. Please try again.");
                }
                
            }
            // If the user gets to this point, it means their input wasn't
            // longer than two characters or less than 20
            else{
            System.out.println("");
            System.out.println("Invalid entry. Name must be between 2 and 20 characters and");
            System.out.println("may only contain letters, spaces, or dashes. Please try again.");
            }
            
            
            
            
        }   
        
         
        
    } // END of readAndVerifyLastName()
    
    
    public static void registerCompetitor(int[] id, String[] firstName, String[] lastName, String[] character, String[] vehicle, int[][] times, int count, Scanner in){
        // This method scans the ID, first name, and last name from the user using
        // the readAndVerify methods. This method also lets the user select
        // their character and vehicle. If the user successfully does this,
        // the method prints a message indicating that to the user. 
        
 
        // First, we start with scanning the ID from the user
        int userID = readAndVerifyID(in);
        // Then we need to save that ID into an array
        id[count] = userID;
        
        // Then scan the first name
        String userFirstName = readAndVerifyName(in);
        
        // Save the first name to an array
        firstName [count]  = userFirstName;
        
        // Scan the last name
        String userLastName  = readAndVerifyLastName(in);
        
        // Save the last name to an array
        lastName [count]  = userLastName;
        
        // With all that done, the user is now allowed to choose their racing
        // character.
        
        // First we start by displaying the character selection menu
        displayCharacterMenu();
        // Now we have to read the user's choice
        int characterChoice =readAndVerifyChoice(in, 16);
        
        // This is being defined to help us in the lines below
        String userCharacter = "";
        
        // Now we have to figure out which character the user selected based on 
        // their input
        if (characterChoice == 1){
            userCharacter = characters[0];
        }
        else if (characterChoice == 2){
            userCharacter = characters[1];
        }
        else if (characterChoice == 3){
            userCharacter = characters[2];
        }
        else if (characterChoice == 4){
            userCharacter = characters[3];
        }
        else if (characterChoice == 5){
            userCharacter = characters[4];
        }
        else if (characterChoice == 6){
            userCharacter = characters[5];
        }
        else if (characterChoice == 7){
            userCharacter = characters[6];
        }
        else if (characterChoice == 8){
            userCharacter = characters[7];
        }
        else if (characterChoice == 9){
            userCharacter = characters[8];
        }
        else if (characterChoice == 10){
            userCharacter = characters[9];
        }
        else if (characterChoice == 11){
            userCharacter = characters[10];
        }
        else if (characterChoice == 12){
            userCharacter = characters[11];
        }
        else if (characterChoice == 13){
            userCharacter = characters[12];
        }
        else if (characterChoice == 14){
            userCharacter = characters[13];
        }
        else if (characterChoice == 15){
            userCharacter = characters[14];
        }
        else if (characterChoice == 16){
            userCharacter = characters[15];
        }
        
        
        // After the user selects a character, they now have to be prompted to
        // select a vehicle
        
        // First we need to display the vehicle choice menu to the user
        displayVehicleMenu();
        // Now we need to read the user's choice
        int vehicleChoice = readAndVerifyChoice(in, 3);
        
        // Based off of which vehicle the user selected, we need to display the
        // appropriate menu to the user- kart, bike, or ATV
        
        
        // Define userVehicle here to assign the user a vehicle based on their
        // numeric input
        String userVehicle = "";
        
        if (vehicleChoice == 1){
            // If the user chose one, display the kart selection menu
            kartSelectionMenu();
            int kartChoice = readAndVerifyChoice(in, 14);
            // Based off of the user input, we'll assign their vehicle a kart
         
            if (kartChoice == 1){
                userVehicle = karts[0];
            }
            else if (kartChoice == 2){
                userVehicle = karts[1];
            }
            else if (kartChoice == 3){
                userVehicle = karts[2];
            }
            else if (kartChoice == 4){
                userVehicle = karts[3];
            }
            else if (kartChoice == 5){
                userVehicle = karts[4];
            }
            else if (kartChoice == 6){
                userVehicle = karts[5];
            }
            else if (kartChoice == 7){
                userVehicle = karts[6];
            }
            else if (kartChoice == 8){
                userVehicle = karts[7];
            }
            else if (kartChoice == 9){
                userVehicle = karts[8];
            }
            else if (kartChoice == 10){
                userVehicle = karts[9];
            }
            else if (kartChoice == 11){
                userVehicle = karts[10];
            }
            else if (kartChoice == 12){
                userVehicle = karts[11];
            }
            else if (kartChoice == 13){
                userVehicle = karts[12];
            }
            else if (kartChoice == 14){
                userVehicle = karts[13];
            }
            
      
        }
        
        else if (vehicleChoice == 2){
            // If the user chose two, display the bike selection menu
            bikeSelectionMenu();
            int bikeChoice = readAndVerifyChoice(in, 9);
            // Based off of the user input, we'll assign their vehicle to a bike
            
            if (bikeChoice == 1){
                userVehicle = bikes[0];
            }
            else if (bikeChoice == 2){
                userVehicle = bikes[1];
            }
            else if (bikeChoice == 3){
                userVehicle = bikes[2];
            }
            else if (bikeChoice == 4){
                userVehicle = bikes[3];
            }
            else if (bikeChoice == 5){
                userVehicle = bikes[4];
            }
            else if (bikeChoice == 6){
                userVehicle = bikes[5];
            }
            else if (bikeChoice == 7){
                userVehicle = bikes [6];
            }
            else if (bikeChoice == 8){
                userVehicle = bikes[7];
            }
            else if (bikeChoice == 9){
                userVehicle = bikes[8];
            }

        }
        
        else if (vehicleChoice == 3){
            // If the user chose three, display the ATV selection menu
            atvSelectionMenu();
            int atvChoice = readAndVerifyChoice(in, 3);
            // Based off of user input, we'll assign their vehicle to a ATV
            
            if (atvChoice == 1){
                userVehicle = ATVs[0];
            }
            else if (atvChoice == 2){
                userVehicle = ATVs[1];
            }
            else if (atvChoice == 3){
                userVehicle = ATVs[2];  
            }
        }
        
        
        
        
        // After all this, we need to display a message indicating the user's
        // successful registration.
        System.out.println("\nYou have successfully registered the following competitor:");
        System.out.println(userFirstName + " " + userLastName + " (ID: " + userID + ")");
        System.out.println("Character: " + userCharacter);
        System.out.println("Vehicle: " + userVehicle);
        
        // We need to save the competitor's character and vehicle into the 
        //corresponding array
        character[count] = userCharacter;
        vehicle[count] = userVehicle;
        
        
                
           
        
    } // END of registerCompetitor
    
    public static void searchByID(int[] id, String[] firstName, String[] lastName, String[] character, String[] vehicle, int[][] times, int numCompetitors, Scanner in){
        // This method scans a specific ID and uses it to search for the id[] 
        // array, then prints the competitor details. If the user hasn't entered
        // a competitor with the searched ID, an error statement will be 
        // displayed to the user
        
        // Initalize these here to calculate minutes and seconds for the user
        // time
        int seconds = 0;
        int minutes = 0;
        int minutes2 = 0;
        
        
            
            // First we need to prompt the user to enter the ID of the competitor
            // that they're searching for
           
            int inputID= readAndVerifyID(in);
            
            // Initalize a flag and set it to false, if we find the corresponding
            // ID in the id array, it'll be set to true
            boolean flag = false;

            // We will check to see if the user input is equal to an ID number
            // by looping through each value in id[]
            for (int i = 0; i < id.length; i++) {
                // IF the user input is equal to a value in the id[] array...we will
                // tell them the competitor was found and display the competitor 
                // details to them
                if (id[i] == inputID) {
                    flag = true;
                    System.out.println("\nCompetitor was successfully found!");
                    System.out.println(firstName[i] + " " + lastName[i] + " (ID: " + id[i] + ")");
                    System.out.println("Character: " + character[i]);
                    System.out.println("Vehicle: " + vehicle[i]);
                    System.out.println("   ***Best Times***   ");
                    for (int j = 0; j < 4; j++){
                            int bestTime = times[i][j];
                            if (bestTime == 0){
                                System.out.println(tracks[j] + ": " + "no time recorded");
                            }
                            else {
                                // convert mins and seconds
                                seconds = bestTime % 60;
                                minutes2 = bestTime / 60;
                                minutes = minutes2 % 60;  
                                // We need to see if the seconds is two-digit or one-digit,
                                // if one-digit, a zero needs to be added in front of the
                                // number
                                String Seconds = String.valueOf(seconds);
                                if (Seconds.length() == 1){
                                    // If the seconds length is 1, we simply add a 0 in 
                                    // front of the single number
                                    System.out.println("    " + tracks[j] + ": " + minutes + "'" + "0" + seconds + "\"");
      
                                }
                                // ELSE, we just print the two digit seconds number
                                else{
                                    System.out.println("    " + tracks [j] + ": " + minutes + "'" + seconds + "\"");
                        
                                }

                            }
                          
                        }
                        break;
                    
                }            
                    
            }
            // If searched and nothing is found
            if (!flag){
                System.out.println("Competitor ID #" + inputID + " was not found in the system.");
                // We will NOT loop back, instead we will take the user back to
                // the menu. I chose to do this because...what if the user has
                // NO registered players and tries to search their ID? If we 
                // keep looping, the user will get stuck!!!
                
            }
        
    } // END of searchByID()
    
    
    public static void searchByName (int[] id, String[] firstName, String[] lastName, String[] character, String[] vehicle, int[][] times, int count, Scanner in){
        // This method will be similar to searchByID(), except, the user will
        // input a competitor's first and last name, and if a competitor 
        // is found, their information will be displayed to the user.
        
        // First we need to prompt the user to enter the first name of the competitor
        // that they're searching for
        
        String inputFirstName = readAndVerifyName(in);
        String inputLastName = readAndVerifyLastName(in);
        
        
        
        // Now we have to search to see if the user's input matches a registered
        // first and last name. 
        // We will do this by checking to see if any value in firstName and 
        // lastName is equal to the user input. Note that we are ignoring the
        // case.
        
        
        // IF it's equal, that means the user entered a valid first and last
        // name, and the program needs display the details on the competitor
        
        // Initalize a flag and set it to false, if we find the corresponding
        // ID in the id array, it'll be set to true
        boolean flag = false;
        
        // Initalize these here to calculate minutes and seconds for the user
        // time
        int seconds = 0;
        int minutes = 0;
        int minutes2 = 0;
        
   
        // FIRST we will check the first name
        for (int i = 0; i < firstName.length; i++) {
            // Break the for loop for the empty space in the array                      
            if (firstName[i] == null) {
                break;
            }
            // if a first name in the first name array matches the user 
            // input.... 
            if (firstName[i].equalsIgnoreCase(inputFirstName)) {
                // We'll check to see if the last name inputted is equal to 
                // a last name in thelast name array

                    // if the last name in the last name array matches input...
                    if (lastName[i].equalsIgnoreCase(inputLastName)) {
                        // If we've gotten this far, it means the first and
                        // last names entered- ignoring the case- matches
                        // a name in the array

                        flag = true;
                        // Now we need to display the competitor's info
                        // to the user
                        System.out.println("");
                        System.out.println("Competitor was successfully found!");
                        System.out.println(firstName[i] + " " + lastName[i] + " (ID: " + id[i] + ")");
                        System.out.println("Character: " + character[i]);
                        System.out.println("Vehicle: " + vehicle[i]);
                        System.out.println("   ***Best Times***   ");
                        for (int j = 0; j < 4; j++) {
                            int bestTime = times[i][j];
                            if (bestTime == 0) {
                                System.out.println(tracks[j] + ": " + "no time recorded");
                            }
                            else {
                                // convert mins and seconds
                                seconds = bestTime % 60;
                                minutes2 = bestTime / 60;
                                minutes = minutes2 % 60;
                                // We need to see if the seconds is two-digit or one-digit,
                                // if one-digit, a zero needs to be added in front of the
                                // number
                                String Seconds = String.valueOf(seconds);
                                if (Seconds.length() == 1){
                                    // If the seconds length is 1, we simply add a 0 in 
                                    // front of the single number
                                    System.out.println("    " + tracks[j] + ": " + minutes + "'" + "0" + seconds + "\"");
      
                                }
                                // ELSE, we just print the two digit seconds number
                                else{
                                    System.out.println("    " + tracks [j] + ": " + minutes + "'" + seconds + "\"");
                        
                                }
                                
                            }

                        }
                        
                    }
                    break;

            }
  
        }
        // If the user enters a first and last name that doesn't
        // equal a first and last name in the array, they will
        // be given an error message and be prompted to try
        // again                
        if (!flag) {

            System.out.println("Competitor \"" + inputFirstName + " " + inputLastName + "\" was not found in the system.");
            // We will NOT loop back, instead we will take the user back to
            // the menu. I chose to do this because...what if the user has
            // NO registered players and tries to search their ID? If we 
            // keep looping, the user will get stuck!!!

        }


    } // END of searchByName ()
    
    
    
    public static void performTimeTrial (int[][] times, int count, Scanner in, Random rng){
        // This method will complete a time trial for every registered 
        // competitor with whichever track the user selects.
        
        // We need to keep track of how many people perform a time trial
        competitorsDoneTimeTrials = count;
        
        
        
        // IF the user has no registered compatitors, they cannot perform a time
        // trial
        if (count < 1){
            System.out.println("Time trials cannot take place, as there are no competitors");
            System.out.println("currently registered in the system.");
            return;
           
            
        }
            
        else{
        // Firstly, we need to display the track selection menu for the user
        // to select their track
        trackSelectionMenu();
        
        // Next, we need to read and verify the input the user enters as they're
        // selecting their track
        int trackInput = readAndVerifyChoice(in, 4);
        
        // Now that we've recieved the user's track choice, we need to grab the
        // values from the global variable that we've set (record times), and
        // then add a random set of seconds to that established time for each
        // competitor
        
        // userTrack and userTime are going to be initalized from the beginning
        String userTrack = "";
        int userTime = 0;
        // for each i
  
        
        
        for (int i = 0; i < count; i++) {
            if (trackInput == 1) {
                userTrack = tracks[0];

                // the user race time will start at the world record and a random
                // number of seconds between 1-29 will be added to it.
                
                // We subtract 1 from track input because the track list goes
                // from 0-3, not 1-4
                times[i][trackInput-1] = recordTimes[0] + rng.nextInt(30);
                // We need to keep track of how many people perform a time trial
                competitorsDoneTimeTrials += i;
                

            }
            else if (trackInput == 2) {
                userTrack = tracks[1];
                times[i][trackInput-1] = recordTimes[1] + rng.nextInt(30);
            }
            else if (trackInput == 3) {
                userTrack = tracks[2];
                times[i][trackInput-1] = recordTimes[2] + rng.nextInt(30);
            }
            else if (trackInput == 4) {
                userTrack = tracks[3];
                times[i][trackInput-1] = recordTimes[3] + rng.nextInt(30);
            }

        }
        // Now we need to tell the user that their new times have been recorded
        System.out.println("\nAll competitors have new times recorded for " + userTrack);
    }
        


    } // END of performTimeTrial()
    
    
    public static void displayLeaderBoard(int[] id, String[] firstName, String[] lastName, String[] character, String[] vehicle, int[][] times, int count) {
        // This method will determine and display the best recorded times for 
        // each of the four tracks to the user. If more than one competitor has 
        // the best time, each will be printed. If a track has no time recorded,
        // an appropriate message will print, informing the user of that

        // To do this, we simply need to find the shortest race time in each 
        // column, then display those times as well as the corresponding 
        // competitor to the user
        // These need to be initalized here to print later when displaying time
        // to the user
        int seconds = 0;
        int minutes = 0;
        int minutes2 = 0;

        // We'll start by initalizing a min aarray named minTime- this will 
        // store each best time for each track.
        int[] minTime = new int[tracks.length];
        // We'll also make an array to save the corresponding user info

        int[] userInfo = new int[tracks.length];

        // As well as a counter to keep track of how many times we need to loop
        int counter = 0;

        // While the count is bigger than the counter- awhile the system has
        // registered competitors, we will keep looping
        while (counter < count) {
            for (int i = 0; i < times.length; i++) {
                for (int j = 0; j < times[i].length; j++) {
                    // make sure the times not 0
                    if (times[i][j] == 0) {
                        continue;
                    }
                    // IF no time in mintime
                    // I got this line with help from peer tutoring :)
                    else if (minTime[j] == 0) {
                        minTime[j] = times[i][j];
                        userInfo[j] = i;

                    }
                    // If the times are smaller than the min, save them into the
                    // min
                    else if (times[i][j] < minTime[j]) {
                        minTime[j] = times[i][j];
                        userInfo[j] = i;
                    }
                }
                // We looped once, add one to the counter
                counter += 1;
            }
        }
        System.out.println("");
        System.out.println("Leaderboard: ");
        for (int k = 0; k < minTime.length; k++) {

            // If the index at midTime is equal to the min value, that means that
            // nothing was added to that index of midTime- therefore- there was
            // no time recorded for that particular track.
            if (minTime[k] == 0) {
                System.out.println("   " + tracks[k]);
                System.out.println("      no time trials recorded");
            }
            // ELSE, there is a valid high score found for that track and it can
            // be displayed for the user
            else {
                System.out.println("   " + tracks[k]);
                System.out.println("      " + firstName[userInfo[k]] + " " + lastName[userInfo[k]] + " (ID: " + id[userInfo[k]] + ")");
                System.out.println("      Character:" + character[userInfo[k]]);
                System.out.println("      Vehicle:" + vehicle[userInfo[k]]);

                // convert mins and seconds
                seconds = minTime[k] % 60;
                minutes2 = minTime[k] / 60;
                minutes = minutes2 % 60;
                // We need to see if the seconds is two-digit or one-digit,
                // if one-digit, a zero needs to be added in front of the
                // number
                String Seconds = String.valueOf(seconds);
                if (Seconds.length() == 1) {
                    // If the seconds length is 1, we simply add a 0 in 
                    // front of the single number
                    System.out.println("    " + "Time: " + minutes + "'" + "0" + seconds + "\"");

                }
                // ELSE, we just print the two digit seconds number
                else {
                    System.out.println("    " + "Time: " + minutes + "'" + seconds + "\"");

                }

            }

        }
    } // END of displayLeaderBoard()
          
 
    
    
    
    public static void displayAllCompetitors(int[] id, String[] firstName, String[] lastName, String[] character, String[] vehicle, int count){
        // This method will display all registered competitors. If there are
        // no registered competitors, an appropriate message will be displayed
        // to the user
        
        // We need to initiate a for loop that'll loop for every 'count', that 
        // being every time we counted a new registered player
        
        // FIRST however we need to check the count, if there are no registered
        // competitors, a message needs to be displayed to the user
        
        if (count < 1){
            System.out.println("There are no competitors currently registered in the system.");
        }
        // If the count is NOT greater than 0, we can loop over each competitor
        // and display their information to the user. We can loop over the 
        // length of firstName. We use firstName instead of count so that we can
        // use the if firstName[i] == null, break. This is to ensure that ONLY
        // the registered competitors are displayed and not the maximum amount
        // of competitors
        else{
            System.out.println("Competitors registered in the system:");
            for (int i = 0; i < firstName.length + 1; i++){
                if (firstName[i] == null){
                    break;
                }
                System.out.println(i+1 + ".  " + firstName[i] + " " + lastName[i] + " (ID: " + id[i] + ")");
                System.out.println("Character: " + character[i]);
                System.out.println("Vehicle: " + vehicle[i]);                           
        }
            
        }

    } // END of displayAllCompetitors()
    
    
    public static void displayStatistics(int[][] times, int count){
        // This method will calculate the average time trial for each track
        // and then display that average to the user. If a track has no recorded
        // time trial, an appropriate message will be displayed to the user
        
        // We also need to initalize these here to use later when printing the
        // average times
        int seconds = 0;
        int minutes2 = 0;
        int minutes = 0;
        
        
        // IF there are no competitors, we cannot display any stats for the user
        if (count < 1){
            System.out.println("There are no statistics recorded, as there are no");
            System.out.println("competitors currently registered in the system.");
        }
        // ELSE if there are competitors, we CAN display those stats for the user
        else{
            // NOW we can go about displaying the average time trial for each 
            // track 
            
            // We need to, basically, get the average of each column.
            // To start, we need to iterate over each competitor for each track
            
            // We also need to define this here, this array will store each
            // average of each track- the average of each column in times[][]
            int [] average = new int [tracks.length];          
            
            for (int i = 0; i < times.length; i++){
                for (int j = 0; j < times[i].length; j++){
                    // Summing times for every track
                    average[j] += times[i][j];
                }     
            }
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
                // IF there is a found time at the specific index in our 
                // averages
                else{
                    // convert mins and seconds
                    seconds = average[k] % 60;
                    minutes2 = average[k] / 60;
                    minutes = minutes2 % 60;
                    // We need to see if the seconds is two-digit or one-digit,
                    // if one-digit, a zero needs to be added in front of the
                    // number
                    String Seconds = String.valueOf(seconds);
                    if (Seconds.length() == 1){
                        // If the seconds length is 1, we simply add a 0 in 
                        // front of the single number
                        System.out.println("    " + tracks[k] + ": " + minutes + "'" + "0" + seconds + "\"");
      
                    }
                    // ELSE, we just print the two digit seconds number
                    else{
                        System.out.println("    " + tracks[k] + ": " + minutes + "'" + seconds + "\"");
                        
                    }
  
                }                              
                
            }
      
            
        }
            
        
    } // END of displayStatistics()
    
    
    
    public static void main (String[] args){
        // Our main method will contain a LOT of helpful items for our program
        
        // The scanner objects used throughout this code only needs to be
        // defined once: HERE
        Scanner in = new Scanner(System.in);
        
        // FIRST things first, we need to ask the user to enter the seed and
        // max number of competitors for this program.
        
        System.out.print("Enter the seed for the random number generator: ");
        int seed = Integer.parseInt(in.nextLine());
        
        // Our random object needs to be defined here so that we can use it
        // whenever needed in the program. NOTE that the seed value is the num
        // that was inputted by the user.
        
        Random rng = new Random (seed);
        
        
        
        
        // We need to ask the user the maximum number of competitors allowed in
        // this program
        System.out.print("Enter the maximum number of competitors: ");
        int maxCompetitors = Integer.parseInt(in.nextLine());
        
        // We also need to declare the arrays here in main
        int [] id = new int [maxCompetitors];
        String [] firstName = new String [maxCompetitors];
        String [] lastName = new String [maxCompetitors];
        String [] character = new String [maxCompetitors];
        String [] vehicle = new String [maxCompetitors];
        
        // For the 2d array, the first bracket stores the maximum competitors
        // and the second bracket stores 4- the number of tracks in the star cup
        int [][] times = new int [maxCompetitors] [4];
        
        // Initalize count
        // NOTE, count will be used to determine how many registered players are
        // in the system. This will be VERY important for multiple methods.
        int count= 0;
  
        // This loop will display the main menu to the user and direct them
        // to whichever menu/game they want to run based off of their input
        while (true){
            displayMenu();
            int choice = readAndVerifyChoice(in, 8);
            if (choice == 1){
                registerCompetitor(id, firstName, lastName, character, vehicle, times, count, in);
                // Increment the count by one everytime user goes to register
                // competitor(), thats how we can keep a current count going
                // of the amount of registered competitors in the system
                count++;
                
            }
            else if (choice == 2){
                searchByID(id, firstName, lastName, character, vehicle, times, count, in);
                
            }
            else if (choice == 3){
                searchByName(id, firstName, lastName, character, vehicle, times, count, in);
            }
            else if (choice == 4){
                performTimeTrial(times, count, in, rng);
            }
            else if (choice == 5){
                displayLeaderBoard(id, firstName, lastName, character, vehicle, times, count);
            }
            else if (choice == 6){
                displayAllCompetitors(id, firstName, lastName, character, vehicle, count);
            }
            else if (choice == 7){
                displayStatistics(times, count);
            }
            else if (choice == 8){
                System.out.println("\nGoodbye!");
                break;
            }
          
        } 
        
    } // END of main()
    
    
    
    
} // END of CSC2290 Program2 class
