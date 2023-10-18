public class Competitor {
    
    // Here we will declare all of our data members
    private int id;
    private String firstName;
    private String lastName;
    private String character;
    private String vehicle;
    private int [] bestTimes;
    // numCompetitors will keep track of how many competitors are registered 
    private static int numCompetitors;
    
    // Constructors:

    // First, our basic no argument constructor
    public Competitor() {
        // number of competitors MUST be incremented here
        numCompetitors++;
        
        // For every competitor registered, an array for their best times must
        // be created at size 4 because there are only 4 tracks
        this.bestTimes = new int[4];
        
    } // END of default constructor
    
    // Next, a constructor taking in the ID, firstName, lastName, character,
    // and vehicle as parameters
    public Competitor(int id, String firstName, String lastName, String character, String vehicle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.vehicle = vehicle;
        
        // We also MUST increment the number of competitors here
        numCompetitors++;
        
        // For every competitor registered, an array for their best times must
        // be created, again, size 4
        this.bestTimes = new int[4];
        
    } // END of second constructor
    
    // Getters:

    public int getId() {
        return id;
    } // END of getId()

    public String getFirstName() {
        return firstName;
    } // END of getFirstName()

    public String getLastName() {
        return lastName;
    } // END of getLastName()

    public String getCharacter() {
        return character;
    } // END of getCharacter()

    public String getVehicle() {
        return vehicle;
    } // END of getVehicle()

    public int[] getBestTimes() {
        return bestTimes;
    } // END of getBestTimes()
    
    public int getBestTimes(int track) {
        return bestTimes[track];
    } // END of getBestTimes()

    public static int getNumCompetitors() {
        return numCompetitors;
    } // END of getNumCompetitors()
    
    // Setters:

    public void setId(int id) {
        this.id = id;
    } // END of setId()

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // END of setFirstName()

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // END of setLastName()

    public void setCharacter(String character) {
        this.character = character;
    } // END of setCharacter()

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    } // END of setVehicle()

    public void setBestTimes(int track, int time) {
        this.bestTimes[track] = time;
        
    } // END of setBestTimes()
    
    // Other Methods:
    
    // Here we will make a better toString() method by overriding the original
    // toString()
    
    @Override
    public String toString(){
        // We will declare String s here. Then we will add concatenate each 
        // line so it looks identical to the expected output.
        String s = "";
        
        // These also need to be initalized here
        int seconds = 0;
        int minutes2 = 0;
        int minutes = 0;
        
        
        s+= String.format(firstName + " " + lastName + " (ID: " + id +")");
        s+= String.format("\nCharacter: " + character);
        s+= String.format("\nVehicle: " + vehicle);
        s+= String.format("\n***Best Times***");
        // if best times is 0, that means the competitor did NOT record a 
        // time for that specific race
        // We need to do this check for EVERY time 
        if (bestTimes[0] == 0) {
            s += String.format("\n   Sunshine Airport: no time recorded");
        }
        else {
            // convert mins and seconds
            seconds = bestTimes[0] % 60;
            minutes2 = bestTimes[0] / 60;
            minutes = minutes2 % 60;
            // We need to see if the seconds is two-digit or one-digit,
            // if one-digit, a zero needs to be added in front of the
            // number
            String Seconds = String.valueOf(seconds);
            if (Seconds.length() == 1) {
                // If the seconds length is 1, we simply add a 0 in 
                // front of the single number
                s+= String.format("\n   Sunshine Airport: " + minutes + "'" + "0" + seconds + "\"");

            }
            // ELSE, we just print the two digit seconds number
            else {
                s+= String.format("\n   Sunshine Airport: " + minutes + "'" + seconds + "\"");

            }
        }
        
        if (bestTimes[1] == 0){
            s+= String.format("\n   Dolphin Shoals:   no time recorded");   
        }
        else{
            // convert mins and seconds
            seconds = bestTimes[1] % 60;
            minutes2 = bestTimes[1] / 60;
            minutes = minutes2 % 60;
            // We need to see if the seconds is two-digit or one-digit,
            // if one-digit, a zero needs to be added in front of the
            // number
            String Seconds = String.valueOf(seconds);
            if (Seconds.length() == 1) {
                // If the seconds length is 1, we simply add a 0 in 
                // front of the single number
                s+= String.format("\n   Dolphin Shoals: " + minutes + "'" + "0" + seconds + "\"");
            }
            // ELSE, we just print the two digit seconds number
            else {
                s+= String.format("\n   Dolphin Shoals: " + minutes + "'" + seconds + "\"");
            }         
        }
        
        if (bestTimes[2] == 0){
            s+= String.format("\n   Electrodrome:     no time recorded");   
        }
        else{
            // convert mins and seconds
            seconds = bestTimes[2] % 60;
            minutes2 = bestTimes[2] / 60;
            minutes = minutes2 % 60;
            // We need to see if the seconds is two-digit or one-digit,
            // if one-digit, a zero needs to be added in front of the
            // number
            String Seconds = String.valueOf(seconds);
            if (Seconds.length() == 1) {
                // If the seconds length is 1, we simply add a 0 in 
                // front of the single number
                s+= String.format("\n   Electrodrome: " + minutes + "'" + "0" + seconds + "\"");
            }
            // ELSE, we just print the two digit seconds number
            else {
                s+= String.format("\n   Electrodrome: " + minutes + "'" + seconds + "\"");
            }        
        }
        
        if (bestTimes[3] == 0){
            s+= String.format("\n   Mount Wario:      no time recorded");       
        }
        else{
            // convert mins and seconds
            seconds = bestTimes[3] % 60;
            minutes2 = bestTimes[3] / 60;
            minutes = minutes2 % 60;
            // We need to see if the seconds is two-digit or one-digit,
            // if one-digit, a zero needs to be added in front of the
            // number
            String Seconds = String.valueOf(seconds);
            if (Seconds.length() == 1) {
                // If the seconds length is 1, we simply add a 0 in 
                // front of the single number
                s+= String.format("\n   Mount Wario: " + minutes + "'" + "0" + seconds + "\"");
            }
            // ELSE, we just print the two digit seconds number
            else {
                s+= String.format("\n   Mount Wario: " + minutes + "'" + seconds + "\"");
            }   
        }
        // Here we need to return the string made in the toString() method
        return s;
    } // END of toString()
    
    
    
    
    
    
} // END of Competitor class
