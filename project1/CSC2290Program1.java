import java.util.*;

public class CSC2290Program1 {
// Eve Collier
// evecollier3@gmail.com
// CSC 2290 Object Oriented Programming
// Program 1: Are You Smarter Than a Third Grader?     

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
    
    //global variable to keep track of total time spent in math practice
    public static float mathPracticeTime = 0.0f;
    
    //global variable to keep track of amount of times user plays guessing game
    public static int guessGameCount = 0;
    
    //global variable to keep track of amount of times user plays addition race 
    //to the finish
    public static int additionRaceGameCount = 0;
    
    //global to keep track of subtraction race to the finish game
    public static int subtractionRaceGameCount = 0;
    
    //global to keep track of multiplication race to the finish game
    public static int multiplicationRaceGameCount = 0;
    
    //global to keep track of division race to the finish game
    public static int divisionRaceGameCount = 0;
    
    // global to keep track of the user's guess game high score
    public static float guessHighScore = 0;
    
    // global to keep track of the user's high score for addition race to the
    // finish
    public static int additionHighScore = 0;
    
    // global to keep track of user's high score for subtraction race to the
    // finish
    public static int subtractionHighScore = 0;
    
    // global to keep track of user's high score for multiplication race to the
    // finish
    public static int multiplicationHighScore = 0;
    
    // global to keep track of user's high score for division race to the finish
    public static int divisionHighScore = 0;
    
    
    public static void showMainMenu() {
        // Here is where we'll print the main menu displayed to the user
        System.out.println("-----------------------------------------------------");
        System.out.println("|       Are You Smarter Than a Third Grader       |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  1. Math Practice                               |");
        System.out.println("|  2. Race to the Finish (Addition)               |");
        System.out.println("|  3. Race to the Finish (Subtraction)            |");
        System.out.println("|  4. Race to the Finish (Multiplication)         |");
        System.out.println("|  5. Race to the Finish (Division)               |");
        System.out.println("|  6. Guess the Number                            |");
        System.out.println("|  7. Exit                                        |");
        System.out.println("---------------------------------------------------");
        // Note we are NOT taking user input here. That will be done in...
        // ...readAndVerifyChoice()
    } // END of showMainMenu()

    public static void showMathPracticeMenu() {
        // Here is where we'll print the math practice menu for the user
        System.out.println("-----------------------------------------------------");
        System.out.println("|      Let's Practice Some Math Questions         |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  1. Addition                                    |");
        System.out.println("|  2. Subtraction                                 |");
        System.out.println("|  3. Multiplication                              |");
        System.out.println("|  4. Division                                    |");
        System.out.println("|  5. Return to Main Menu                         |");
        System.out.println("---------------------------------------------------");
        // Note we are NOT taking user input here either. readAndVerifyChoice()
        // will handle that
    } //END of showMathPracticeMenu()

    public static int readAndVerifyChoice(Scanner in, int numChoices) {
        // This method will scan the user's choice for either the main or the 
        // math practice menus.       

        // We will enter a loop to do this 
        while (true) {
            // First we need to actually get the user input
            System.out.print("\nEnter your choice: ");
            String userNum = in.nextLine();
            // If the user's input is longer than 1 character, it'll tell the 
            // user that they made an invalid choice, and then let them 
            // enter their input again
            if (userNum.length() != 1 || Integer.parseInt(userNum) == 0) {
                System.out.println("");
                System.out.println("Invalid choice. Please try again.");
            }
            // Next we have to make sure the input is a digit
            else if (containsOnlyDigits(userNum)) {
                // If this passes, this means the input is a digit. Now we can
                // parse the input as an int
                int userNum2 = Integer.parseInt(userNum);
                // Next we need to make sure the user selected a number within
                // the choices avalible to them on the menu
                if (userNum2 <= numChoices) {
                    return userNum2;
                }
                // If the if doesn't pass, that means the user selected a
                // number not avaliable                 
                else {
                    System.out.println("");
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            //If the user gets to this point, that means the user didn't put 
            // a number in
            else  {
                System.out.println("");
                System.out.println("Invalid choice. Please try again.");
            }


        }
    } //End of readAndVerifyChoice()

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

    public static int readAndVerifyInt(Scanner in, int num1, int num2, String op) {
        // Here we are verifying that the user inputs a valid answer for any
        // asked question
        while (true) {
            // We're ready to take input from the user
            String userAnsw = in.nextLine();
            // We need to check and make sure the input is an int
            if (containsOnlyDigits(userAnsw)) {
                // If the answer is a number, we can parse the input into an int
                // instead of a string
                return Integer.parseInt(userAnsw);
            }
            // if the if statement doesn't execute, that means the user didn't 
            // answer with an int
            System.out.println("");
            System.out.println("Invalid entry. Please try again.");
            // The %s gets replaced with each function argument, then prints to
            // the user
            System.out.printf("%d %s %d =", num1, op, num2);

        }

    } //END of readAndVerifyInt()

    public static void mathPractice(Scanner in, Random rng) {
        // If the user decides to do the math practice, this method will 
        // run the actual math practice
        
        float entireMathPracticeTime = 0;

        while (true) {
            //We need to start the timer.
            long mathPracticeStartTime = System.currentTimeMillis();
           
            //First, the memu needs to be displayed to the user.
            showMathPracticeMenu();
            // Next, the user's answer needs to be assigned to whichever operator
            // they chose.
            int userInput = readAndVerifyChoice(in, 5);

            //if the user chose 1, that means they chose addition
            if (userInput == 1) {
                // This is the counter that'll keep track of how many problems
                // the user answers correctly
                int correctAnsw = 0;

                String op = "+"; //this is addition
                System.out.println("Here are five Addition questions to practice:");
                System.out.println("");
                // The for loop will ask the user five questions
                for (int i = 1; i <= 5; i++) {
                    // We need to generate two random numbers between 1 and 12
                    int num1 = 1 + rng.nextInt(12);
                    int num2 = 1 + rng.nextInt(12);
                    // This prints the question out to the user
                    System.out.print(i + "." + " " + num1 + " " + op + " " + num2 + " " + "=" + " ");
                    // Then we need to verify the user's answer
                    int userAnsw = readAndVerifyInt(in, num1, num2, op);
                    // IF the answer is equal to the addition problem, its correct
                    if (userAnsw == num1 + num2) {
                        System.out.println("Correct!");
                        // We also need to add one to the counter
                        correctAnsw += 1;
                    }
                    // If the answer isn't correct, it's incorrect!
                    else {
                        //First we print the error message, then the correct
                        // answer
                        System.out.println("Incorrect. The correct answer is:");
                        System.out.print(num1 + " " + op + " " + num2 + " " + "=" + " ");
                        System.out.print(num1 + num2);
                        System.out.println("");
                        System.out.println("");
                    }

                }

                // Once all five questions are answered and we're out of the for
                // loop, we need to tell the user how many questions they got
                // correct, then tell them they can either practice more or 
                // return to the main menu. Then, this will loop back to the 
                // top of the while loop, and the user can decide what to do.
                System.out.println("");
                System.out.println("You got" + " " + correctAnsw + " " + "out of 5 correct.");
                System.out.println("You can now practice some more or return to the Main Menu.");
                System.out.println("");

            }
            // This entire else if will be the same as the addition, but with a
            // minor change.
            else if (userInput == 2) {
                int correctAnsw = 0;

                String op = "-";
                System.out.println("Here are five Subtraction questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = 1 + rng.nextInt(12);
                    int num2 = 1 + rng.nextInt(12);
                    // temporaryNum2 is created to serve as a placeholder in
                    // case we need to swap num1 and num2 
                    int temporaryNum2 = 0;
                    // IF the second number is greater than the first, we simlpy
                    // need to swap them so there's no negatives
                    if (num2 > num1) {
                        temporaryNum2 = num1;
                        num1 = num2;
                        num2 = temporaryNum2;

                    }
                    System.out.print(i + "." + " " + num1 + " " + op + " " + num2 + " " + "=" + " ");
                    int userAnsw = readAndVerifyInt(in, num1, num2, op);
                    if (userAnsw == num1 - num2) {
                        System.out.println("Correct!");
                        correctAnsw += 1;
                    }
                    else {
                        System.out.println("Incorrect. The correct answer is:");
                        System.out.print(num1 + " " + op + " " + num2 + " " + "=" + " ");
                        System.out.print(num1 - num2);
                        System.out.println("");
                        System.out.println("");
                    }
                }
                System.out.println("");
                System.out.println("You got" + " " + correctAnsw + " " + "out of 5 correct.");
                System.out.println("You can now practice some more or return to the Main Menu.");
                System.out.println("");
            }
            // This entire else if will be the same as addition and subtraction,
            // but as multiplication
            else if (userInput == 3) {
                int correctAnsw = 0;

                String op = "x";
                System.out.println("Here are five Multiplication questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = 1 + rng.nextInt(12);
                    int num2 = 1 + rng.nextInt(12);
                    System.out.print(i + "." + " " + num1 + " " + op + " " + num2 + " " + "=" + " ");
                    int userAnsw = readAndVerifyInt(in, num1, num2, op);
                    if (userAnsw == num1 * num2) {
                        System.out.println("Correct!");
                        correctAnsw += 1;
                    }
                    else {
                        System.out.println("Incorrect. The correct answer is:");
                        System.out.print(num1 + " " + op + " " + num2 + " " + "=" + " ");
                        System.out.print(num1 * num2);
                        System.out.println("");
                        System.out.println("");
                    }
                }
                System.out.println("");
                System.out.println("You got" + " " + correctAnsw + " " + "out of 5 correct.");
                System.out.println("You can now practice some more or return to the Main Menu.");
                System.out.println("");
            }
            // Division will be a little bit different- only because
            // of the math.
            else if (userInput == 4) {
                int correctAnsw = 0;

                String op = "/";
                System.out.println("Here are five Division questions to practice:");
                System.out.println("");
                for (int i = 1; i <= 5; i++) {
                    int num1 = 1 + rng.nextInt(12);
                    int num2 = 1 + rng.nextInt(12);
                    // For division, we should make a third number and set it 
                    //equal to the first two.
                    int num3 = num1 * num2;
                    System.out.print(i + "." + " " + num3 + " " + op + " " + num1 + " " + "=" + " ");
                    int userAnsw = readAndVerifyInt(in, num3, num1, op);
                    // To check if the user's number is correct, we'll see if
                    // Their answer is equal to third number created divided
                    // by the first number. This is equal to the two numbers
                    // divided and will ensure every number the user gets
                    // will be divisible by a whole number
                    if (userAnsw == num3 / num1) {
                        System.out.println("Correct!");
                        correctAnsw += 1;
                    }
                    else {
                        System.out.println("Incorrect. The correct answer is:");
                        System.out.print(num3 + " " + op + " " + num1 + " " + "=" + " ");
                        System.out.print(num3 / num1);
                        System.out.println("");
                        System.out.println("");
                    }
                }
                System.out.println("");
                System.out.println("You got" + " " + correctAnsw + " " + "out of 5 correct.");
                System.out.println("You can now practice some more or return to the Main Menu.");
                System.out.println("");
            }
            // The last menu choice means the user wants to return to the main
            // menu.   
            else if (userInput == 5) {
                // End the timer since user is exiting
                long mathPracticeEndTime = System.currentTimeMillis();
                // Add it to total time
                float seconds = (mathPracticeEndTime - mathPracticeStartTime) / (float)1000;
                entireMathPracticeTime += seconds;

                //return to main menu
                break;
            }

        }
        mathPracticeTime += entireMathPracticeTime;

    } //END of mathPractice()

    public static void displayRaceToTheFinishMenu(String op) {
        // This will print the menu for Race to the Finish

        // We need to display the menu pertaining to the operator that the user
        // inputs.
        // if the operator is +, the user wants the addition version of
        // race to the finish
        if (op.equals("+")) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|               Race to the Finish                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|    You have 10 seconds to answer as many        |");
            System.out.println("|    addition questions as possible.              |");
            System.out.println("|    Both the Questions and the Timer will start  |");
            System.out.println("|    once you type anything and click \"Enter\".    |");
            System.out.println("---------------------------------------------------");

        }
        // if the operator is -, the user wants the subtraction version of
        // race to the finish
        else if (op.equals("-")) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|               Race to the Finish                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|    You have 10 seconds to answer as many        |");
            System.out.println("|    subtraction questions as possible.           |");
            System.out.println("|    Both the Questions and the Timer will start  |");
            System.out.println("|    once you type anything and click \"Enter\".  |");
            System.out.println("---------------------------------------------------");

        }
        // if the operator is *, the user wants the multiplication version of
        // race to the finish
        else if (op.equals("*")) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|               Race to the Finish                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|    You have 10 seconds to answer as many        |");
            System.out.println("|    multiplication questions as possible.        |");
            System.out.println("|    Both the Questions and the Timer will start  |");
            System.out.println("|    once you type anything and click \"Enter\".  |");
            System.out.println("---------------------------------------------------");
        }
        // if the operator is /, the user wants the division version of
        // race to the finish
        else if (op.equals("/")) {
            System.out.println("-----------------------------------------------------");
            System.out.println("|               Race to the Finish                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|    You have 10 seconds to answer as many        |");
            System.out.println("|    division questions as possible.              |");
            System.out.println("|    Both the Questions and the Timer will start  |");
            System.out.println("|    once you type anything and click \"Enter\".  |");
            System.out.println("---------------------------------------------------");

        }

    } //END of displayRaceToTheFinishMenu()

    public static int raceToTheFinish(Scanner in, Random rng, String op) {
        // This will run the "Race to the Finish" portion of the program

        // First we need to figure out exactly WHICH "Race to the Finish" the
        // user is selecting
        // Display the addition menu to the user
        
        
        
        if (op.equals("+")) {
            displayRaceToTheFinishMenu("+");
            // Pause the program until the user hits "Enter"
            in.nextLine();
            // The timer that's timing the user
            long userStartTime = System.currentTimeMillis();
            long currentTime = userStartTime;
            // countDown is 10 seconds
            long countDown = 10000;

            // We also need to keep track of how many questions the user gets
            // correct
            int correctAnsw = 0;
            
            // We also need to keep track of the user's best amount of correct
            // answers.
            
            
            // On top of that, we need to be able to tell whether or not this is
            // the user's first time playing or not
            
            additionRaceGameCount++;
            
            
            

            // awhile the user's time is greater than the countdown, the loop
            // can run
            
            while (currentTime - userStartTime < countDown) {
              
                int num1 = 1 + rng.nextInt(12);
                int num2 = 1 + rng.nextInt(12);
                // This prints the question out to the user
                System.out.print(num1 + " " + op + " " + num2 + " " + "=" + " ");
                // Then we need to verify the user's answer
                int userAnsw = readAndVerifyInt(in, num1, num2, op);
                // IF the answer is equal to the addition problem, its correct
                if (userAnsw == num1 + num2) {
                    System.out.println("Correct!");
                    // We also need to add one to the counter
                    correctAnsw += 1;
                }
                // If the answer isn't correct, it's incorrect!
                else {
                    // We print the error message
                    System.out.println("Incorrect.");
                }
                // We need to check the user's current time again
                currentTime = System.currentTimeMillis();
                // If the user runs out of time awhile answering, print this
                if (currentTime - userStartTime > countDown) {
                    System.out.println("");
                    System.out.println("You didn't quite get that last answer in quick enough.");
                    if (userAnsw == num1 + num2){
                        // If the user got the question correct, it will NOT
                        // be added to their total correct answers
                        correctAnsw+=-1;
                    }
                }

            }
            // If the while loop doesn't pass, that means the user ran out of time.
            System.out.println("Time is up! Let's see how you did...");
            // IF the user has only played once
            if (additionRaceGameCount<=1){
                System.out.println("");
                System.out.println("This was your first time playing. As such, your" + " " + correctAnsw + " " + "questions answered in 10 seconds is currently the best!");
                System.out.println("");
                // The current high score is the current amount of answers the
                // user got correct
                additionHighScore += correctAnsw;
            }
            // IF the useer has played more than once
            else if (additionRaceGameCount>=2){
                // IF the user's current score beat the high score
                if (correctAnsw > additionHighScore){
                    System.out.println("");
                    System.out.println("Your score of" + " " + correctAnsw + " " + "just beat the previous score of" + " " + additionHighScore + " Awesome job!");
                    System.out.println("");
                    //return highScore;
                    // The highest score is now the user's current score
                    additionHighScore = correctAnsw;
                }
                // IF the user did NOT beat the high score
                else{
                    System.out.println("");
                    System.out.println("Good effort, but you'll have to try harder to beat your best score of " + additionHighScore);
                    System.out.println("");
                    //return highScore;
                }
                
            }
            

        }
        
        
        else if (op.equals("-")) {
            displayRaceToTheFinishMenu("-");
            // Pause the program until the user hits "Enter"
            in.nextLine();
            // The timer that's timing the user
            long userStartTime = System.currentTimeMillis();
            long currentTime = userStartTime + 1;
            // countDown is 10 seconds
            long countDown = 10000;

            // We also need to keep track of how many questions the user gets
            // correct
            int correctAnsw = 0;
            
            
            
            // On top of that, we need to be able to tell whether or not this is
            // the user's first time playing or not
            
            subtractionRaceGameCount++;
            
            // awhile the user's time is greater than the countdown, the loop
            // can run
            
            while (currentTime - userStartTime < countDown) {
                int num1 = 1 + rng.nextInt(12);
                int num2 = 1 + rng.nextInt(12);
                // temporaryNum2 is created to serve as a placeholder in
                // case we need to swap num1 and num2 
                int temporaryNum2 = 0;
                // IF the second number is greater than the first, we simlpy
                // need to swap them so there's no negatives
                if (num2 > num1) {
                    temporaryNum2 = num1;
                    num1 = num2;
                    num2 = temporaryNum2;
                }
                // This prints the question out to the user
                System.out.print(num1 + " " + op + " " + num2 + " " + "=" + " ");
                // Then we need to verify the user's answer
                int userAnsw = readAndVerifyInt(in, num1, num2, op);
                // IF the answer is equal to the addition problem, its correct
                
                if (userAnsw == num1 - num2) {
                    System.out.println("Correct!");
                    // We also need to add one to the counter
                    correctAnsw += 1;
                }
                // If the answer isn't correct, it's incorrect!
                else {
                    // We print the error message
                    System.out.println("Incorrect.");
                }
                // We need to check the user's current time again
                currentTime = System.currentTimeMillis();
                // If the user runs out of time awhile answering, print this
                if (currentTime - userStartTime > countDown) {
                    System.out.println("");
                    System.out.println("You didn't quite get that last answer in quick enough.");
                    if (userAnsw == num1 + num2){
                        // If the user got the question correct, it will NOT
                        // be added to their total correct answers
                        correctAnsw+=-1;
                    }
                }

            }
            // If the while loop doesn't pass, that means the user ran out of time.
            System.out.println("Time is up! Let's see how you did...");
            // IF the user has only played once
            if (subtractionRaceGameCount<=1){
                System.out.println("");
                System.out.println("This was your first time playing. As such, your" + " " + correctAnsw + " " + "questions answered in 10 seconds is currently the best!");
                System.out.println("");
                // The current high score is the current amount of answers the
                // user got correct
                subtractionHighScore += correctAnsw;
            }
            // IF the useer has played more than once
            else if (subtractionRaceGameCount>=2){
                // IF the user's current score beat the high score
                if (correctAnsw > subtractionHighScore){
                    System.out.println("");
                    System.out.println("Your score of" + " " + correctAnsw + " " + "just beat the previous score of" + " " + subtractionHighScore + "Awesome job!");
                    System.out.println("");
                    //return highScore;
                    // The highest score is now the user's current score
                    subtractionHighScore = correctAnsw;
                }
                // IF the user did NOT beat the high score
                else{
                    System.out.println("");
                    System.out.println("Good effort, but you'll have to try harder to beat your best score of " + subtractionHighScore);
                    System.out.println("");
                    //return highScore;
                }
                
            }
            
        }

        else if (op.equals("*")) {
            displayRaceToTheFinishMenu("*");
            // Pause the program until the user hits "Enter"
            in.nextLine();
            // The timer that's timing the user
            long userStartTime = System.currentTimeMillis();
            long currentTime = userStartTime;
            // countDown is 10 seconds
            long countDown = 10000;

            // We also need to keep track of how many questions the user gets
            // correct
            int correctAnsw = 0;
            
            // On top of that, we need to be able to tell whether or not this is
            // the user's first time playing or not
            
            multiplicationRaceGameCount++;
            


            // awhile the user's time is greater than the countdown, the loop
            // can run
            while (currentTime - userStartTime < countDown) {
                int num1 = 1 + rng.nextInt(12);
                int num2 = 1 + rng.nextInt(12);
                // This prints the question out to the user
                System.out.print(num1 + " " + op + " " + num2 + " " + "=" + " ");
                // Then we need to verify the user's answer
                int userAnsw = readAndVerifyInt(in, num1, num2, op);
                // IF the answer is equal to the addition problem, its correct
                if (userAnsw == num1 * num2) {
                    System.out.println("Correct!");
                    // We also need to add one to the counter
                    correctAnsw += 1;
                }
                // If the answer isn't correct, it's incorrect!
                else {
                    // We print the error message
                    System.out.println("Incorrect.");
                }
                // We need to check the user's current time again
                currentTime = System.currentTimeMillis();
                // If the user runs out of time awhile answering, print this
                if (currentTime - userStartTime > countDown) {
                    System.out.println("");
                    System.out.println("You didn't quite get that last answer in quick enough.");
                    if (userAnsw == num1 + num2){
                        // If the user got the question correct, it will NOT
                        // be added to their total correct answers
                        correctAnsw+=-1;
                    }
                }

            }
            // If the while loop doesn't pass, that means the user ran out of time.
            System.out.println("Time is up! Let's see how you did...");
            // IF the user has only played once
            if (multiplicationRaceGameCount<=1){
                System.out.println("This was your first time playing. As such, your" + " " + correctAnsw + " " + "questions answered in 10 seconds is currently the best!");
                // The current high score is the current amount of answers the
                // user got correct
                multiplicationHighScore += correctAnsw;
            }
            // IF the useer has played more than once
            else if (multiplicationRaceGameCount>=2){
                // IF the user's current score beat the high score
                if (correctAnsw > multiplicationHighScore){
                    System.out.println("Your score of" + " " + correctAnsw + " " + "just beat the previous score of" + " " + multiplicationHighScore + "Awesome job!");
                    //return highScore;
                    // The highest score is now the user's current score
                    multiplicationHighScore = correctAnsw;
                }
                // IF the user did NOT beat the high score
                else{
                    System.out.println("Good effort, but you'll have to try harder to beat your best score of " + multiplicationHighScore);
                    //return highScore;
                }
                
            }
   
        }

        else if (op.equals("/")) {
            displayRaceToTheFinishMenu("/");
            // Pause the program until the user hits "Enter"
            in.nextLine();
            // The timer that's timing the user
            long userStartTime = System.currentTimeMillis();
            long currentTime = userStartTime;
            // countDown is 10 seconds
            long countDown = 10000;

            // We also need to keep track of how many questions the user gets
            // correct
            int correctAnsw = 0;
            
            
            // On top of that, we need to be able to tell whether or not this is
            // the user's first time playing or not
            
            divisionRaceGameCount++;
            

            // awhile the user's time is greater than the countdown, the loop
            // can run
            while (currentTime - userStartTime < countDown) {
                int num1 = 1 + rng.nextInt(12);
                int num2 = 1 + rng.nextInt(12);
                // For division, we should make a third number and set it 
                    //equal to the first two.
                    int num3 = num1 * num2;                      
                // This prints the question out to the user
                System.out.print(num3 + " " + op + " " + num1 + " " + "=" + " ");
                // Then we need to verify the user's answer
                int userAnsw = readAndVerifyInt(in, num3, num1, op);
                // IF the answer is equal to the addition problem, its correct
                if (userAnsw == num3 / num1) {
                    System.out.println("Correct!");
                    // We also need to add one to the counter
                    correctAnsw += 1;
                }
                // If the answer isn't correct, it's incorrect!
                else {
                    // We print the error message
                    System.out.println("Incorrect.");
                }
                // We need to check the user's current time again
                currentTime = System.currentTimeMillis();
                // If the user runs out of time awhile answering, print this
                if (currentTime - userStartTime > countDown) {
                    System.out.println("");
                    System.out.println("You didn't quite get that last answer in quick enough.");
                    if (userAnsw == num1 + num2){
                        // If the user got the question correct, it will NOT
                        // be added to their total correct answers
                        correctAnsw+=-1;
                    }
                }

            }
            // If the while loop doesn't pass, that means the user ran out of time.
            System.out.println("Time is up! Let's see how you did...");
            // IF the user has only played once
            if (divisionRaceGameCount<=1){
                System.out.println("");
                System.out.println("This was your first time playing. As such, your" + " " + correctAnsw + " " + "questions answered in 10 seconds is currently the best!");
                System.out.println("");
                // The current high score is the current amount of answers the
                // user got correct
                divisionHighScore += correctAnsw;
            }
            // IF the useer has played more than once
            else if (divisionRaceGameCount>=2){
                // IF the user's current score beat the high score
                if (correctAnsw > divisionHighScore){
                    System.out.println("");
                    System.out.println("Your score of" + " " + correctAnsw + " " + "just beat the previous score of" + " " + divisionHighScore + "Awesome job!");
                    System.out.println("");
                    //return highScore;
                    // The highest score is now the user's current score
                    divisionHighScore = correctAnsw;
                }
                // IF the user did NOT beat the high score
                else{
                    System.out.println("");
                    System.out.println("Good effort, but you'll have to try harder to beat your best score of " + divisionHighScore);
                    System.out.println("");
                    //return highScore;
                }
                
            }
            
            
            
        }

        return additionHighScore;
    } //END of raceToTheFinish()

    public static void displayGuessMenu() {
        //Here we will print the menu for the number guessing game for the user
        System.out.println("-----------------------------------------------------");
        System.out.println("|       How Quickly Can You Guess My Number       |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|   Let's play the childhood number guessing game!|");
        System.out.println("|   I'll choose a number between 1 and 100. Your  |");
        System.out.println("|   job is to guess my number as quickly as you   |");
        System.out.println("|   can. Can you beat the best previous time?     |");
        System.out.println("|                                                 |");
        System.out.println("| --- Timer starts once you hit \"Enter\" ---       |");
        System.out.println("---------------------------------------------------");
        
        
        // Note, just like the other menu methods, the user input is NOT taken 
        // here.

    } //END of displayGuessMenu()

    public static float numberGuessingGame(Scanner in, Random rng) {
        // This will run the number guessing game portion of program
        
       
        
        // Firstly, we need to display the menu to the user
        displayGuessMenu();
        
        // KEEP TRACK of how many games the user plays 
        guessGameCount ++;
        
        
        
        //We need to generate a random number between 1-100 for the user to
        //guess
        int number = 1 + rng.nextInt(100);
        
        // Pause the program until the user hits "Enter"
        in.nextLine();
        
        
        // Start the timer.
        long userStartTime = System.currentTimeMillis();
        // Declare variables 
        int gameCount = 0;
        float totalTime = 0;
        int userGuess = 0;
        
        // While loop to keep asking the user to enter their guess awhile their
        // guess does NOT equal the number
        while (userGuess != number){
            
            // use read and verify guess to make sure the number is a int
            userGuess = readAndVerifyGuess(in);
            
            // IF the user didn't guess the number...
            // Print to the user that their guess is too high if its higher than
            // the number
            if (userGuess != number){
                if (userGuess > number){
                    System.out.println("Your guess is too high.");
                }
                // Same thing if the guess is too low
                else if (userGuess < number){
                    System.out.println("Your guess is too low.");
                }
            }
            // If the if statement doesn't execute- the user guessed the number!
            else{
                System.out.println("You guessed the correct number!");
                
            }
        }

                // This is done to figure out the user's total time spent
                // guessing
                totalTime = (System.currentTimeMillis() - userStartTime) / 1000;
                System.out.println("Total time taken: " + totalTime + " seconds");
                // Only display this message on the user's FIRST playthrough
                if (guessGameCount <= 1){
                    System.out.println("");
                    System.out.println("This was your first time playing. As such, your time of " + totalTime + " is the current best time!");
                    System.out.println("");
                    guessHighScore = totalTime;
            }
                // If the user's played more than once and beat their high score, print
                // the 'congrats' message and save their time to the high score
                if(totalTime<guessHighScore && guessGameCount >=2) {
                    System.out.println("");
                    System.out.println("You just beat your previous best time of " + guessHighScore + " seconds!");
                    System.out.println("The new best time is now " + totalTime);
                    System.out.println("");
                    guessHighScore = totalTime;  
                }
                if (totalTime > guessHighScore && guessGameCount>=2){
                    System.out.println("");
                    System.out.println("Good effort, but you'll have to try harder to beat your best time of " + guessHighScore + " seconds.");   
                    System.out.println("");
                }
 
        return guessHighScore;

        

    } //END of numberGuessingGame()

    public static int readAndVerifyGuess(Scanner in) {
        // Will validate the user inputted guess as an int
        int userNum2 = 0;
        // We will enter a loop to do this 
        while (true) {
            // First we need to actually get the user input
            System.out.print("\nEnter your choice: ");
            String userNum = in.nextLine();
            // If the user's input is not longer than 0 characters, it'll tell the 
            // user that they made an invalid choice, and then let them 
            // enter their input again
            if (userNum.length() < 1) {
                System.out.println("");
                System.out.println("Invalid choice. Please try again.");
            }
            // Next we have to make sure the input is a digit
            if (containsOnlyDigits(userNum)) {
                // If this passes, this means the input is a digit. Now we can
                // parse the input as an int
                userNum2 = Integer.parseInt(userNum); 
            }
            //If the user gets to this point, that means the user didn't put 
            // a number in
            else {
                System.out.println("");
                System.out.println("Invalid choice. Please try again.");
            }
            
            return userNum2;
        }
        
      
        

    } //END of readAndVerifyGuess()

    public static void main(String[] args) {
        // Main method. We'll make a lot of helpful things available here

        // The scanner objects used throughout this code only needs to be
        // defined once: HERE
        Scanner in = new Scanner(System.in);

        // The same goes for the random object. It just needs to be defined here
        // and then refrenced wherever needed
        Random rng = new Random(777);
        
  

        
        
        // We need to keep track of the user's total time on the app
        long userTotalAppStartTime = System.currentTimeMillis();
        
        
        // This loop will display the main menu to the user and direct them
        // to whichever menu/game they want to run based off of their input
        
        
        while (true){
            showMainMenu();
            int choice = readAndVerifyChoice(in, 7);
            if (choice == 1){
                mathPractice(in, rng);
            }
            else if (choice == 2){
                raceToTheFinish(in, rng, "+");       
            }
            else if (choice == 3){
                raceToTheFinish(in, rng, "-");
            }
            else if (choice == 4){
                raceToTheFinish(in, rng, "*");
            }
            else if (choice ==5) {
                raceToTheFinish(in, rng, "/");
            }
            else if (choice == 6) {
                numberGuessingGame(in, rng);
            }
            else if (choice == 7){
                break;
            }

        }
        
        // User stats
        
        // Lets start with the total time spent on this app
        long userTotalAppEndTime = System.currentTimeMillis();
        float timeSeconds = (userTotalAppEndTime - userTotalAppStartTime) / (float) 1000.0;
        // Awesome, now we just need to display it in minutes and seconds
        float seconds = 0;
        float minutes = 0;
        float minutes2 = 0;
        
        // Mathy stuff to divide the total seconds into minutes and seconds
        // We will round the minutes and seconds in the print statement
        // To get rid of the decimals
        seconds = timeSeconds % 60;
        minutes2 = timeSeconds / 60;
        minutes = minutes2 % 60;
        
        // We also need to split the total seconds spent in math practice into
        // minutes and seconds
        float mathPracSeconds = 0;
        float mathPracMinutes = 0;
        float mathPracMinutes2 = 0;
        
        mathPracSeconds = mathPracticeTime % 60;
        mathPracMinutes2 = mathPracticeTime / 60;
        mathPracMinutes = mathPracMinutes2 % 60;
        
        
      

        
     
        
        
        
        String stats;
        
        // We ask the user if they'd like to see their stats
        System.out.print("\nDo you want to see stats from the app today (yes/no): ");
        stats = in.nextLine();
        if (stats.equals("yes")){

        // And now, finally, we print all of the user's stats, since the user
        // said YES!
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Stats from your visit today: ");
        System.out.println("");
        System.out.println("1. Time spent on Math Practice: " + Math.round(mathPracMinutes) + " minute(s) and " + Math.round(mathPracSeconds) +" second(s)");
        System.out.println("");
        System.out.println("2. Most questions answered in 10 seconds: ");
        // If the addition score is 0, we want to tell the user they didn't
        // attempt the addition race to the finish game
        if (additionHighScore == 0){
            System.out.println("   Addition: not attempted");
        }
        else{
            System.out.println("   Addition: " + additionHighScore);
        }
        // If the subtraction score is 0, we want to tell the user they didn't 
        // attempt the subtraction race to the finish game
        if (subtractionHighScore == 0){
            System.out.println("   Subtraction: not attempted");
        }
        else{
            System.out.println("   Subtraction: " + subtractionHighScore);
        }
            
        // If the multiplication score is 0, we want to tell the user they did
        // not attempt the multiplication race to the finish game
        if (multiplicationHighScore == 0){
            System.out.println("   Multiplication: not attempted");
        }
        else{
            System.out.println("   Multiplication: " + multiplicationHighScore);
        }
             
        // If the division score is 0, we want to tell the user they didn't
        // attempt the division race to the finish game
        if (divisionHighScore == 0){
            System.out.println("   Division: not attempted");
        }
        else{
            System.out.println("   Division: " + divisionHighScore);
        }
            
        System.out.println("");
        System.out.println("3. Best time for guessing the secret number: " + guessHighScore + " seconds");
        System.out.println("");
        System.out.println("Total time spent using app: " + Math.round(minutes)  + " minute(s) and " + Math.round(seconds) + " second(s)");
        System.out.println("");
        System.out.println("Hope this was fun!");
           
        } 
        // If the user says NO or anything else, they get no stats :(
        else{
            System.out.println("\nHope this was fun!");
        }
        
  
    }//END of main()

} //END of CSC2290Program1 CLASS
