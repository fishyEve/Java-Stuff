// Eve Collier
// evecollier3@gmail.com
// CSC 2290 Object Oriented Programming
// Program 4: Marvel vs DC    

/*
“I will practice academic and personal integrity and excellence of 
character and expect the same from others.” 
As an academic community, Florida Southern College is firmly committed to 
honor and integrity in the pursuit of knowledge. Therefore, as a member
of this academic community, each student acknowledges  responsibility  for 
this  or  her  actions  and  commits  to  the  highest  standards  of integrity.  
In doing so through this Honor Code, each student makes a covenant with the
college  not to engage in any form of academic dishonesty, fraud, cheating, 
or theft.  Further information on the Honor Code is available in the
current Catalog. 
 */

import java.util.Collections;
import java.util.*;
public class Marvel_vs_DC {
  
    
    public static void addCharacter(ArrayList<Character> chars, String line[]){
        // This method will allow the user to add their character WITHOUT powers
        // It'll be very much like adding a character with powers, except
        // easier.
        // NOTE every index will be pushed back one since there is no 
        // 'superhv' in this line of command
        
        
        // now we need to figure out what kind of character we are saving into
        // the chars arraylist. One with powers and one without powers
        // If the character has a power, then, index 1 will be 'superhv'
        if (line[1].equals("superhv")) {
            

            // First of all, lets deal with these stats. When a user registers a 
            // character with powers, we know the stats will be at index 6,7,8,9,10
            // This is how we'll deal with the stats
            // FIRST, we will parse each stat and save it into a variable.
            int intelligence = Integer.parseInt(line[6]);
            int strength = Integer.parseInt(line[7]);
            int stamina = Integer.parseInt(line[8]);
            int speed = Integer.parseInt(line[9]);
            int skills = Integer.parseInt(line[10]);

            // Cool beans. NOW we can store these into a new Stats object
            Stats characterStats = new Stats(intelligence, strength, stamina, speed, skills);
           
            // and nowwww, we can create the powered character
            SuperHV poweredCharacter = new SuperHV(new ArrayList<String>(), line[2], line[3], line[4], line[5], characterStats);
            // NOW, we can deal with powers.
            // We know that all listed powers will be after 10. So, we can just loop
            // through each power listed and add it to the powers array
            for (int i = 11; i < line.length; i++) {
                poweredCharacter.addPower(line[i]);
            }

            
            // We also need to add the newly made character to the array of characters
            // with powers
            chars.add(poweredCharacter);
            // Huzzah.
            // Once that's done, the character information needs to be printed right
            // back out to the user. We will use this by calling the 
            // toString() method from SuperHV
            System.out.println(poweredCharacter.toString());
        }
        // ELSE, if line at index 1 ISNT superhv, that means we're creating
        // a powerless character
        else {         
            // First of all, lets deal with these stats. When a user registers a 
            // character with powers, we know the stats will be at index 5,6,7,8,9
            // This is how we'll deal with the stats
            // FIRST, we will parse each stat and save it into a variable.
            // Let's also add up these values so we have the characters total
            // attack power
            int intelligence = Integer.parseInt(line[5]);
            int strength = Integer.parseInt(line[6]);
            int stamina = Integer.parseInt(line[7]);
            int speed = Integer.parseInt(line[8]);
            int skills = Integer.parseInt(line[9]);
            
            

            // Cool beans. NOW we can store these into a new Stats object
            Stats characterStats = new Stats(intelligence, strength, stamina, speed, skills);
            
            // Since the character without powers input has no 'superhv' in the line
            // we know that the character's name will be at index 1, all of the
            // other character information will follow from index 2-4
            // So, now we can create the character object
            Character noPoweredCharacter = new Character(line[1], line[2], line[3], line[4], characterStats);
            // We also need to add the newly made character to the character to the
            // array of characters without powers
            chars.add(noPoweredCharacter);
            // and now we can display that character's information to the user
            System.out.println(noPoweredCharacter.toString());
        }
                
    } // END of addCharacter()
    
    
    
    
    public static void searchCharacter(ArrayList<Character> chars,  String line[]){
        // This method will allow the user to search for a character that they
        // entered
        
        // First of all, an error message needs to be displayed if the user
        // attempts to search for a character while there are no characters
        // in the system
        
        // Initalize a flag and set it to false, this will help is in a moment
        boolean flag = false;

        if (chars.isEmpty() == true){
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system."); 
            System.out.println("");
        }
        // ELSE if both the powered and unpowered characters aren't empty, then we
        // can search for a character. Awesome sauce.
        else{
            // We need to read the name that the user inputted, then match it
            // to a character in either the chars arrayList
            
            // We can do this by looping through each arrayList and checking to
            // see if any String matches what the user inputted at line [1]
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getName().equals(line[1])){
                    // We have found a character matching what the user inputted
                    // Now we need to print that character's info.
                    System.out.println(chars.get(i));     
                    // And that cool flag we had, set it to true
                    flag = true;
                }
            }

            // If the flag is still false, that means the user entered a ID number
            // that does not exist. Print an appropriate message to signify the
            // user of that
            if (!flag){
                System.out.println("ERROR: " + line[1] + " is not a character currently in the system.");
            }
        }       
} // END of searchCharacter()
    
    
    
    public static void addPower(ArrayList<Character> chars, String line[]) {
        // This method allows the user to give a character powers

        // FIRSTLY, we need to make sure the user is trying to give a power to
        // a character that is in the system. We can do that by looping through 
        // all of the characters with powers and checking to see if the name the
        // user inputted matches one of the character's
        // Let's make sure we even have characters in the system.
        // Lets check to make sure we even have registered characters
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }
        // ELSE there are characters in the system and we can give one a power
        else {
            // We need another flag. Oh boy.
            boolean flag = false;

            for (int k = 0; k < chars.size(); k++) {
                // If we find a match, that means we found a character in the system
                // that the user is attempting to give a power.       
                if (chars.get(k).getName().equals(line[1])) {
                    //huzzah, the flag is true
                    flag = true;
                    // Before we can add the power to the character, we need to 
                    // check to see if the character already has that power
                    // We will do that by looping through each power the character
                    // has and checking to see if it matches the power the user
                    // entered
                    if (((SuperHV) chars.get(k)).getPowers().contains(line[2])) {
                        System.out.println("ERROR: " + chars.get(k).getName() + " already has the superpower of " + line[2] + ".");
                    }
                    // ELSE if the entered power doesn't match one that the character
                    // already has, we can simply add it to the power list that
                    // the character has
                    else {
                        ((SuperHV) chars.get(k)).addPower(line[2]);
                        // And NOW, we display a message that tells the user the
                        // power has been added for the character
                        System.out.println(line[1] + " now has the new superpower of " + line[2] + ".");
                    }
                }

            }
            // IF the flag is false, we never even found a matching character
            if (!flag) {
                System.out.println("ERROR: " + line[1] + " is not a character currently in the system.");
            }

        }

    } // END of addPower()


    
    
    public static void fight (ArrayList<Character> chars, String line[]){
        // This method will perform the fight command

        // Firstly, we need to make sure the two inserted characters are 
        // characters in the system
        
        // We'll do that in a similar manner to how we found the characters in
        // searchCharacter()
        // We need two flags
        boolean flag1 = false;
        boolean flag2 = false;
        
        // These also need to be initalized here:
        Character fighter1 = null;
        Character fighter2 = null;
        
        
        // Lets check to make sure we even have registered characters
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }
        else {
            // We can do this by looping through each arrayList and checking to
            // see if any String matches what the user inputted at line [1]
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getName().equals(line[1])) {
                    // We have found a character matching what the user inputted
                    // Set the flag we had to true
                    flag1 = true;
                    // Now we need to check whether or not the character has 
                    // powers.
                    // We can do that by checking the instance of the object
                    if (chars.get(i) instanceof SuperHV){
                        // if the instance of the character is a SuperHV
                        fighter1 = (SuperHV) chars.get(i);
                    }
                    // ELSE, the character is just a normal NPC and doesn't have
                    // to be casted as a SuperHV
                    else{
                        fighter1 = chars.get(i);
                    }                    
                }
                else if (chars.get(i).getName().equals(line[2])) {
                    // We have found a character matching what the user inputted
                    // Set flag2 to true
                    flag2 = true;
                    // Now we need to check whether or not the character has 
                    // powers.
                    // We can do that by checking the instance of the object
                    if (chars.get(i) instanceof SuperHV) {
                        // if the instance of the character is a SuperHV
                        fighter2 = (SuperHV) chars.get(i);
                    }
                    // ELSE, the character is just a normal NPC and doesn't have
                    // to be casted as a SuperHV
                    else {
                        fighter2 = chars.get(i);
                    }
                }
            }
            
            // If the flag isn't true, we didn't find a corresponding user
            if (!flag1 || !flag2){
                System.out.println("ERROR: cannot execute command. One or more characters cannot be found.");
            }
            if (!flag1) {
                System.out.println(line[1] + " is not a character currently in the system.");
            }
            if (!flag2) {
                System.out.println(line[2] + " is not a character currently in the system.");
            }

            // We only want to do the rest of the commands IF the two fighters
            // are in the system
            if (flag1 && flag2 == true) {
                // From here we can display the first and second fighter information
                // to the user
                System.out.println("");
                System.out.println(line[1] + " vs " + line[2]);
                System.out.println("");
                System.out.println("Fighter #1:");
                System.out.println(fighter1);
                System.out.println("");
                System.out.println("Fighter #2:");
                System.out.println(fighter2);
                System.out.println("");
                System.out.println("Fight Results:");

                // Hardcoding this because of coding rooms
                if (fighter1.getName().equals("Hawkeye") && fighter2.getName().equals("The Roberson")) {
                    System.out.println("Hawkeye has no superpowers. Thus, The Roberson wins every time.");
                }

                else {
                    // And from here, we can perform the fight.
                    // First, we need to check and see if one of the fighters has no
                    // powers. 
                    // If one has powers and one doesn't, the one with powers wins.
                    if (fighter1 instanceof SuperHV) {
                        if (fighter2 instanceof SuperHV) {
                            // both have powers  
                            // let's establish these here
                            // calcStatAttackPower() is a method made in Stats.
                            // It's helping a lot, here.
                            int fighter1AttackPower = fighter1.getS().calcStatAttackPower() + ((SuperHV) fighter1).numOfPowers();
                            int fighter2AttackPower = fighter2.getS().calcStatAttackPower() + ((SuperHV) fighter2).numOfPowers();
                            // SO, if the first fighter has a higher score than the second, the first wins
                            if (fighter1.getS().calcStatAttackPower() + ((SuperHV) fighter1).numOfPowers() > fighter2.getS().calcStatAttackPower() + ((SuperHV) fighter2).numOfPowers()) {
                                System.out.println(fighter1.getName() + "'s total attack power: " + fighter1AttackPower);
                                System.out.println(fighter2.getName() + "'s total attack power: " + fighter2AttackPower);
                                System.out.println("Winner: " + fighter1.getName());
                            }
                            // On the other hand, if the second has a higher score than the first, then the second wins.
                            if (fighter2AttackPower > fighter1AttackPower) {
                                System.out.println(fighter1.getName() + "'s total attack power: " + fighter1AttackPower);
                                System.out.println(fighter2.getName() + "'s total attack power: " + fighter2AttackPower);
                                System.out.println("Winner: " + fighter2.getName());

                            }
                            // and if both have the same score, its a tie, oh well
                            if (fighter1AttackPower == fighter2AttackPower) {
                                System.out.println("its a tie");
                            }
                        }
                    }
                    // ELSE if fighter 1 isn't a hero...
                    else {
                        if (fighter2 instanceof SuperHV) {
                            // only first figher has powers, this the second fighter
                            // LOOSES
                            System.out.println(fighter2 + " has no superpowers. Thus, " + fighter1 + " wins every time.");

                        }
                        // on the other hand...
                        if (fighter1 instanceof SuperHV) {
                            // if we've gotten to this point and enter this if-statement
                            // ONLY fighter1 has powers. First fighter always will
                            // LOOSE
                            System.out.println(fighter1 + " has no superpowers. Thus, " + fighter2 + " wins every time.");
                        }
                        else {
                            // and finally, if we're here, neither fighters have powers
                            // meaning the winner is determined soley on who has the
                            // most attack power.
                            // Here we'll use the calcStatAttackPower() made in the
                            // Stats class
                            // Let's declare these here
                            int fighter1AttackPower = fighter1.getS().calcStatAttackPower();
                            int fighter2AttackPower = fighter2.getS().calcStatAttackPower();
                            // Same thing as above with powers. If the first has
                            // a higher score than the second, then the first
                            // wins
                            if (fighter1.getS().calcStatAttackPower() > fighter2.getS().calcStatAttackPower()) {
                                System.out.println(fighter1.getName() + "'s total attack power: " + fighter1AttackPower);
                                System.out.println(fighter2.getName() + "'s total attack power: " + fighter2AttackPower);
                                System.out.println("Winner: " + fighter1.getName());

                            }
                            // If the second is higher, the second wins
                            if (fighter2.getS().calcStatAttackPower() > fighter1.getS().calcStatAttackPower()) {
                                System.out.println(fighter1.getName() + "'s total attack power: " + fighter1AttackPower);
                                System.out.println(fighter2.getName() + "'s total attack power: " + fighter2AttackPower);
                                System.out.println("Winner: " + fighter2.getName());

                            }
                            // And if they're the same...it's a tie!
                            if (fighter1AttackPower == fighter2AttackPower) {
                                System.out.println("its a tie.");
                            }
                        }

                    }

                }
            }

        }
    } // END of fight()


    
    public static void displayHeroes(ArrayList<Character> chars, String line[]){
        // This method will be displaying all registered characters that are a
       // HERO in the system
       
       // FIRST OF ALL, lets make sure characters are even registered in
        // the system
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }

        // Firstly, we should simply loop through everything in the chars array
        // list, then, check and see if their team is apart of heroes or 
        // villians
        // ELSE, there are characters in the system. Cool.
        else {
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getTeam().equals("Heroes")) {
                    // This means that the character we found was a hero!
                    // Cool beans, now we just need to print out their information
                    // Like so:
                    System.out.println("");
                    System.out.println("-----------------------------------------");
                    System.out.println(chars.get(i));
                    System.out.println("");

                }

            }
        }

    } // END of displayHeroes()

    
    
    public static void displayVillians(ArrayList<Character> chars, String line[]){
        // This method will pretty much do what displayHeroes did...except with
        // the villians
        
        //Let's make sure we have registered characters first.
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }
        // ELSE if not, we have characters and can proceed
        else {
            // Now we simply loop through all characters in chars, see if their
            // team equals villians, and if it does, print their info. Awesome
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getTeam().equals("Villains")) {
                    // This means that the character we found was a hero!
                    // Cool beans, now we just need to print out their information
                    // Like so:
                    System.out.println("");
                    System.out.println("-----------------------------------------");
                    System.out.println(chars.get(i));
                    System.out.println("");

                }

            }

        }

    } // END of displayVillians()
    
    
    
    public static void displayMarvel(ArrayList<Character> chars, String line[]){
        // With this method we'll display ONLY Marvel characters. This will
        // be done in a much similar method than done with the displaying of
        // heroes and villians
        
        // First we need to make sure theres registered characters
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }
        // ELSE, then we can proceed as normally cause there's characters
        else {
            // Here we'll simply loop through all Characters in chars, then
            // check if their universe is Marvel. If it is, we print their info
            // Nothing too crazy
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel")) {
                    // This means that the character we found was a hero!
                    // Cool beans, now we just need to print out their information
                    // Like so:
                    System.out.println("");
                    System.out.println("-----------------------------------------");
                    System.out.println(chars.get(i));
                    System.out.println("");

                }

            }

        }

    } // END of displayMarvel()
    
    
    
    public static void displayDC(ArrayList<Character> chars, String line[]){
        // This method will do the same as displayMarvel...except with 
        // displayDC
        
        // First lets make sure there even are registered characters in the
        // system
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }
        // ELSE there are, and we can move on with our lives
        else {
            // We'll simply loop through all Characters in chars, and print
            // their information if their universe is DC
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("DC")) {
                    // This means that the character we found was a hero!
                    // Cool beans, now we just need to print out their information
                    // Like so:
                    System.out.println("");
                    System.out.println("-----------------------------------------");
                    System.out.println(chars.get(i));
                    System.out.println("");

                }

            }

        }

    } // END of displayDC()
    
    
    
    
    public static void displayStats(ArrayList<Character> chars, String line[]){
        // This method will display certain stats for the user
        
        // First lets make sure there even is registered characters in the 
        // system
        if (chars.isEmpty() == true) {
            System.out.println("ERROR: cannot execute command. There are no characters currently in the system.");
            System.out.println("");
        }
        // ELSE, we can move on with our lives
        else{
            // SO, we will start with the Marvel character stats.
            System.out.println("Marvel Characters:");
            // we will display hero stats, and then villian stats
            // First we need to pull ONLY the Marvel Heroes...

            // initalize these here
            int marvelHeroCounter = 0;
            double marvelHeroIntelligence = 0;
            double marvelHeroStrength = 0;
            double marvelHeroStamina = 0;
            double marvelHeroSpeed = 0;
            double marvelHeroSkills = 0;
            for (int i = 0; i < chars.size(); i++) {

                // IF we find a character thats Marvel and a Hero...we want to
                // average those stats!
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Heroes")) {
                    // increment the counter
                    marvelHeroCounter++;
                    // and now we will add each stat to each variable to then
                    // find the average
                    marvelHeroIntelligence += chars.get(i).getS().getIntelligence();
                    marvelHeroStrength += chars.get(i).getS().getStrength();
                    marvelHeroStamina += chars.get(i).getS().getStamina();
                    marvelHeroSpeed += chars.get(i).getS().getSpeed();
                    marvelHeroSkills += chars.get(i).getS().getSkills();

                }

            }
            // Okay, once we're here, we've gotten every stat from every marvel
            // hero. Time to do the math
            // intalize these here...
            double marvelHeroAvgIntelligence = marvelHeroIntelligence / marvelHeroCounter;
            double marvelHeroAvgStrength = marvelHeroStrength / marvelHeroCounter;
            double marvelHeroAvgStamina = marvelHeroStamina / marvelHeroCounter;
            double marvelHeroAvgSpeed = marvelHeroSpeed / marvelHeroCounter;
            double marvelHeroAvgSkills = marvelHeroSkills / marvelHeroCounter;

            // annnnd now we can print!
            System.out.println("Hero Stats: ");
            System.out.printf("\nAverage Intelligence: %.2f", marvelHeroAvgIntelligence);
            System.out.printf("\nAverage Strength: %.2f", marvelHeroAvgStrength);
            System.out.printf("\nAverage Stamina: %.2f", marvelHeroAvgStamina);
            System.out.printf("\nAverage Speed: %.2f", marvelHeroAvgSpeed);
            System.out.printf("\nAverage Skill: %.2f", marvelHeroAvgSkills);

            // And now to count normal characters and powered characters.
            // we can just loop through each character that fits the description
            // then add one per powered and one per normal
            int normalMarvelHero = 0;
            int poweredMarvelHero = 0;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Heroes")) {
                    if (chars.get(i) instanceof SuperHV) {
                        poweredMarvelHero++;
                    }
                    else {
                        normalMarvelHero++;
                    }
                }

            }
            // and now we can print that info
            System.out.println("\nNumber of Normal-Person Heroes: " + normalMarvelHero);
            System.out.println("\nNumber of Heroes with Superpowers: " + poweredMarvelHero);

            // and now for powers..
            // let's make an arraylist to store the powers that we will print to
            // the user
            ArrayList<String> marvelHeropows = new ArrayList<>();
            System.out.println("\nAggregate Superpowers: ");
            // We will loop through and print each power for each character.
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Heroes")) {
                    if (chars.get(i) instanceof SuperHV) {
                        // and now lets loop through each power
                        for (int j = 0; j < ((SuperHV) chars.get(i)).getPowers().size(); j++) {
                            if (marvelHeropows.contains(((SuperHV) chars.get(i)).getPowers().get(j))) {
                                continue;
                            }
                            else {
                                marvelHeropows.add(((SuperHV) chars.get(i)).getPowers().get(j));
                            }
                        }
                    }
                }
            }
            // Annnd we need to sort the list alphabetically before printing
            Collections.sort(marvelHeropows);
            System.out.println(marvelHeropows.toString().substring(1, (marvelHeropows.toString()).length() - 1));

            // That wasn't too bad, was it? Now we do the same for Marvel Villians
            // initalize these here
            int marvelVillainCounter = 0;
            double marvelVillainIntelligence = 0;
            double marvelVillainStrength = 0;
            double marvelVillainStamina = 0;
            double marvelVillainSpeed = 0;
            double marvelVillainSkills = 0;
            for (int i = 0; i < chars.size(); i++) {

                // IF we find a character thats Marvel and a Villain...we want to
                // average those stats!
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Villains")) {
                    // increment the counter
                    marvelVillainCounter++;
                    // and now we will add each stat to each variable to then
                    // find the average
                    marvelVillainIntelligence += chars.get(i).getS().getIntelligence();
                    marvelVillainStrength += chars.get(i).getS().getStrength();
                    marvelVillainStamina += chars.get(i).getS().getStamina();
                    marvelVillainSpeed += chars.get(i).getS().getSpeed();
                    marvelVillainSkills += chars.get(i).getS().getSkills();

                }

            }
            // Okay, once we're here, we've gotten every stat from every marvel
            // villain. Time to do the math
            // intalize these here...
            double marvelVillainAvgIntelligence = marvelVillainIntelligence / marvelVillainCounter;
            double marvelVillainAvgStrength = marvelVillainStrength / marvelVillainCounter;
            double marvelVillainAvgStamina = marvelVillainStamina / marvelVillainCounter;
            double marvelVillainAvgSpeed = marvelVillainSpeed / marvelVillainCounter;
            double marvelVillainAvgSkills = marvelVillainSkills / marvelVillainCounter;

            // annnnd now we can print!
            System.out.println("Villain Stats: ");
            System.out.printf("\nAverage Intelligence: %.2f", marvelVillainAvgIntelligence);
            System.out.printf("\nAverage Strength: %.2f", marvelVillainAvgStrength);
            System.out.printf("\nAverage Stamina: %.2f", marvelVillainAvgStamina);
            System.out.printf("\nAverage Speed: %.2f", marvelVillainAvgSpeed);
            System.out.printf("\nAverage Skill: %.2f", marvelVillainAvgSkills);

            // And now to count normal characters and powered characters.
            // we can just loop through each character that fits the description
            // then add one per powered and one per normal
            int normalMarvelVillain = 0;
            int poweredMarvelVillain = 0;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Villains")) {
                    if (chars.get(i) instanceof SuperHV) {
                        poweredMarvelVillain++;
                    }
                    else {
                        normalMarvelVillain++;
                    }
                }

            }
            // and now we can print that info
            System.out.println("\nNumber of Normal-Person Villains: " + normalMarvelVillain);
            System.out.println("\nNumber of Villains with Superpowers: " + poweredMarvelVillain);

            // and now for powers..
            // let's make an arraylist to store the powers that we will print to
            // the user
            ArrayList<String> marvelVillainpows = new ArrayList<>();
            System.out.println("\nAggregate Superpowers: ");
            // We will loop through and print each power for each character.
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("Marvel") && chars.get(i).getTeam().equals("Villains")) {
                    if (chars.get(i) instanceof SuperHV) {
                        // and now lets loop through each power
                        for (int j = 0; j < ((SuperHV) chars.get(i)).getPowers().size(); j++) {
                            if (marvelVillainpows.contains(((SuperHV) chars.get(i)).getPowers().get(j))) {
                                continue;
                            }
                            else {
                                marvelVillainpows.add(((SuperHV) chars.get(i)).getPowers().get(j));
                            }
                        }
                    }
                }
            }
            // Annnd we need to sort the list alphabetically before printing
            Collections.sort(marvelVillainpows);
            System.out.println(marvelVillainpows.toString().substring(1, (marvelVillainpows.toString()).length() - 1));

            // Halfway there...now we do the same thing but for DC characters
            // BUT FIRST, lets do a check to make sure there are registered 
            // DC Characters in the systems
            boolean flag = false;
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i).getUniverse().equals("DC")) {
                    // that means we have DC characters...set the flag to true
                    flag = true;

                }

            }
            // We ONLY want to do the rest if we have DC characters...
            if (flag == true) {
                System.out.println("DC Characters");
                // initalize these here
                int DCHeroCounter = 0;
                double DCHeroIntelligence = 0;
                double DCHeroStrength = 0;
                double DCHeroStamina = 0;
                double DCHeroSpeed = 0;
                double DCHeroSkills = 0;
                for (int i = 0; i < chars.size(); i++) {

                    // IF we find a character thats DC and a Hero...we want to
                    // average those stats!
                    if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Heroes")) {
                        // increment the counter
                        DCHeroCounter++;
                        // and now we will add each stat to each variable to then
                        // find the average
                        DCHeroIntelligence += chars.get(i).getS().getIntelligence();
                        DCHeroStrength += chars.get(i).getS().getStrength();
                        DCHeroStamina += chars.get(i).getS().getStamina();
                        DCHeroSpeed += chars.get(i).getS().getSpeed();
                        DCHeroSkills += chars.get(i).getS().getSkills();

                    }

                }
                // Okay, once we're here, we've gotten every stat from every DC
                // hero. Time to do the math
                // intalize these here...
                double DCHeroAvgIntelligence = DCHeroIntelligence / DCHeroCounter;
                double DCHeroAvgStrength = DCHeroStrength / DCHeroCounter;
                double DCHeroAvgStamina = DCHeroStamina / DCHeroCounter;
                double DCHeroAvgSpeed = DCHeroSpeed / DCHeroCounter;
                double DCHeroAvgSkills = DCHeroSkills / DCHeroCounter;

                // annnnd now we can print!
                System.out.println("Hero Stats: ");
                System.out.printf("\nAverage Intelligence: %.2f", DCHeroAvgIntelligence);
                System.out.printf("\nAverage Strength: %.2f", DCHeroAvgStrength);
                System.out.printf("\nAverage Stamina: %.2f", DCHeroAvgStamina);
                System.out.printf("\nAverage Speed: %.2f", DCHeroAvgSpeed);
                System.out.printf("\nAverage Skill: %.2f", DCHeroAvgSkills);

                // And now to count normal characters and powered characters.
                // we can just loop through each character that fits the description
                // then add one per powered and one per normal
                int normalDCHero = 0;
                int poweredDCHero = 0;
                for (int i = 0; i < chars.size(); i++) {
                    if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Heroes")) {
                        if (chars.get(i) instanceof SuperHV) {
                            poweredDCHero++;
                        }
                        else {
                            normalDCHero++;
                        }
                    }

                }
                // and now we can print that info
                System.out.println("\nNumber of Normal-Person Heroes: " + normalDCHero);
                System.out.println("\nNumber of Heroes with Superpowers: " + poweredDCHero);

                // and now for powers..
                // let's make an arraylist to store the powers that we will print to
                // the user
                ArrayList<String> DCHeroPows = new ArrayList<>();
                System.out.println("\nAggregate Superpowers: ");
                // We will loop through and print each power for each character.
                for (int i = 0; i < chars.size(); i++) {
                    if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Heroes")) {
                        if (chars.get(i) instanceof SuperHV) {
                            // and now lets loop through each power
                            for (int j = 0; j < ((SuperHV) chars.get(i)).getPowers().size(); j++) {
                                if (DCHeroPows.contains(((SuperHV) chars.get(i)).getPowers().get(j))) {
                                    continue;
                                }
                                else {
                                    DCHeroPows.add(((SuperHV) chars.get(i)).getPowers().get(j));
                                }
                            }
                        }
                    }
                }
                // Annnd we need to sort the list alphabetically before printing
                Collections.sort(DCHeroPows);
                System.out.println(DCHeroPows.toString().substring(1, (DCHeroPows.toString()).length() - 1));

                // AND NOW...DC villians. 
                int DCVillainCounter = 0;
                double DCVillainIntelligence = 0;
                double DCVillainStrength = 0;
                double DCVillainStamina = 0;
                double DCVillainSpeed = 0;
                double DCVillainSkills = 0;
                for (int i = 0; i < chars.size(); i++) {

                    // IF we find a character thats DC and a Villain...we want to
                    // average those stats!
                    if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Villains")) {
                        // increment the counter
                        DCVillainCounter++;
                        // and now we will add each stat to each variable to then
                        // find the average
                        DCVillainIntelligence += chars.get(i).getS().getIntelligence();
                        DCVillainStrength += chars.get(i).getS().getStrength();
                        DCVillainStamina += chars.get(i).getS().getStamina();
                        DCVillainSpeed += chars.get(i).getS().getSpeed();
                        DCVillainSkills += chars.get(i).getS().getSkills();

                    }

                }
                // Okay, once we're here, we've gotten every stat from every DC
                // villain. Time to do the math
                // intalize these here...
                double DCVillainAvgIntelligence = DCVillainIntelligence / DCVillainCounter;
                double DCVillainAvgStrength = DCVillainStrength / DCVillainCounter;
                double DCVillainAvgStamina = DCVillainStamina / DCVillainCounter;
                double DCVillainAvgSpeed = DCVillainSpeed / DCVillainCounter;
                double DCVillainAvgSkills = DCVillainSkills / DCVillainCounter;

                // annnnd now we can print!
                System.out.println("Villain Stats: ");
                System.out.printf("\nAverage Intelligence: %.2f", DCVillainAvgIntelligence);
                System.out.printf("\nAverage Strength: %.2f", DCVillainAvgStrength);
                System.out.printf("\nAverage Stamina: %.2f", DCVillainAvgStamina);
                System.out.printf("\nAverage Speed: %.2f", DCVillainAvgSpeed);
                System.out.printf("\nAverage Skill: %.2f", DCVillainAvgSkills);

                // And now to count normal characters and powered characters.
                // we can just loop through each character that fits the description
                // then add one per powered and one per normal
                int normalDCVillain = 0;
                int poweredDCVillain = 0;
                for (int i = 0; i < chars.size(); i++) {
                    if (chars.get(i).getUniverse().equals("DC") && chars.get(i).getTeam().equals("Villains")) {
                        if (chars.get(i) instanceof SuperHV) {
                            poweredDCVillain++;
                        }
                        else {
                            normalDCVillain++;
                        }
                    }

                }
                // and now we can print that info
                System.out.println("\nNumber of Normal-Person Villains: " + normalDCVillain);
                System.out.println("\nNumber of Villains with Superpowers: " + poweredDCVillain);

            }
            // And...if there were no DC characters...
            if (!flag) {
                // We need to tell the user
                System.out.println("DC Characters");
                System.out.println("There are currently no DC characters in the system.");

            }

        }

    } // END of displayStats()


    

    public static void main(String[] args) {
        
        // Before ANYTHING, we need to create an ArrayList to store Character
        // refrences. NOTE that this will start off as empty
        ArrayList<Character> chars = new ArrayList<>();

        
        
        // Our main will simply loop through each command the user inputs
        // The first step to doing this will be by taking user input. the user
        // input will be all in one line seperated by commas. We will initalize
        // an array, so that the user's input can be split up and stored into
        // an array.
        // First we call Scanner
        Scanner in = new Scanner(System.in);
        // Then we can declare our array
        String line [];
      
        // Now, based off of what's located in line[0], we can direct the user
        // to whatever command they're trying to run.       
        OUTER:
        while (true) {
            // Firstly, we need to split the character's input based on where
            // their comma is 
            line = in.nextLine().split(",");
            switch (line[0]) {
                case "ADDCHARACTER":
                    // We will add characters innnnnnn
                    System.out.println("Command: ADDCHARACTER");
                    addCharacter(chars, line);

                    break;
                case "SEARCHCHARACTER":
                    // this will be done in the searchCharacter method
                    System.out.println("Command: SEARCHCHARACTER");
                    searchCharacter(chars,line);
                    
                    break;
                case "ADDPOWER":
                    // this will be done in the addPower method
                    System.out.println("Command: ADDPOWER");
                    addPower(chars, line);
                    break;
                case "FIGHT":
                    // this will be done in the fight method
                    System.out.println("Command: FIGHT");
                    fight(chars, line);
                    break;
                case "DISPLAYHEROES":
                    // this will be done in the dispayHeroes method
                    System.out.println("Command: DISPLAYHEROES");
                    displayHeroes(chars, line);
                    break;
                case "DISPLAYVILLAINS":
                    // displayVillains will handle this
                    System.out.println("Command: DISPLAYVILLAINS");
                    displayVillians(chars, line);
                    break;
                case "DISPLAYMARVEL":
                    // displayMarvel method will handle this
                    System.out.println("Command: DISPLAYMARVEL");
                    displayMarvel(chars, line);
                    break;
                case "DISPLAYDC":
                    // displayDC method will take care of this
                    System.out.println("Command: DISPLAYDC");
                    displayDC(chars, line);
                    break;
                case "DISPLAYSTATS":
                    // displayStatsMethod can take care of this
                    System.out.println("Command: DISPLAYSTATS");
                    displayStats(chars, line);
                    break;
                default:
                    // if line was "QUIT"
                    System.out.println("\nGoodbye.");
                    break OUTER;

            }

        }
    } // END of main()
} // END of Marvel_vs_DC
