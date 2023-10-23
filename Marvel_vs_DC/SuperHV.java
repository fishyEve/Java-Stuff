import java.util.*;
public class SuperHV extends Character {
    // FIRST we need to declare all of our data members
    private ArrayList<String> powers;
    
    // That was a lot of data members. Phew. Now we can create our needed 
    // constructors

    public SuperHV() {
        
    } // end of no-arg constructor

    public SuperHV(ArrayList<String> powers, String name, String team, String universe, String homePlanet) {
        super(name, team, universe, homePlanet);
        this.powers = powers;
    } // end of constructor

    public SuperHV(ArrayList<String> powers, String name, String team, String universe, String homePlanet, Stats s) {
        super(name, team, universe, homePlanet, s);
        this.powers = powers;
    } // end of another constructor
    

    public SuperHV(String name, String team, String universe, String homePlanet, Stats s) {
        super(name, team, universe, homePlanet, s);
    } // end of ANOTHER constructor...can never have too many
    
    
    // And now...getters and setters

    public ArrayList<String> getPowers() {
        return powers;
    } // end of getPowers()

    public void setPowers(ArrayList<String> powers) {
        this.powers = powers;           
    } // end of setPowers()
    
    // Annnnd an overwritten toString() method
    @Override
    public String toString() {
        String s = "";
        s += String.format("\nName: " + getName());
        s += String.format ("\nTeam: " + getTeam());
        s += String.format ("\nUniverse: " + getUniverse());
        s += String.format ("\nHome Planet: " + getHomePlanet());
        s += String.format ("\nStats: " + getS());
        // Here we are making a substring of the toString() of getPowers(), 
        // after 1, where [ will be and the getpowers.length-1, where ] will be
        s += String.format ("\nPowers: " + getPowers().toString().substring(1, getPowers().toString().length()-1)); 

        return s;
    } // end of toString()
    
    // Helpful function, addPower(), will add a powers to a SuperHV char
    // This is real helpful for the ADDPOWER command
    
    public void addPower (String power){
        this.powers.add(power);
        
    } // end of addPower
    
    // Another helpful function, numOfPowers(). Will count up the total number
    // of powers a char has.
    
    public int numOfPowers(){
        int pow = 0;
        
        for (int i = 0; i < powers.size(); i++) {
            pow+=10;   
        }
        
        
        return pow;
    } // end of numOfPowers()
    

    
    
} // End of SuperHV class
