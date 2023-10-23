import java.util.*;
public class Character {
    
    // FIRST we need to declare our data members
    private String name;
    private String team;
    private String universe;
    private String homePlanet;
    private Stats s;

    // Awesome. Now we can insert our needed constructors

    public Character() {
        
    } // end of no-arg constructor

    public Character(String name, String team, String universe, String homePlanet) {
        this.name = name;
        this.team = team;
        this.universe = universe;
        this.homePlanet = homePlanet;
    } // end of constructor

    public Character(String name, String team, String universe, String homePlanet, Stats s) {
        this.name = name;
        this.team = team;
        this.universe = universe;
        this.homePlanet = homePlanet;
        this.s = s;
    } // end of another constructor
    
    // Cool, now we can put in getters and setters

    public String getName() {
        return name;
    } // end of getName()

    public void setName(String name) {
        this.name = name;
    } // end of setName()

    public String getTeam() {
        return team;
    } // end of getTeam()

    public void setTeam(String team) {
        this.team = team;
    } // end of setTeam()

    public String getUniverse() {
        return universe;
    } // end of getUniverse()

    public void setUniverse(String universe) {
        this.universe = universe;
    } // end of setUniverse()

    public String getHomePlanet() {
        return homePlanet;
    } // end of getHomePlanet()

    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    } // end of setHomePlanet()

    public Stats getS() {
        return s;
    } // end of getS()

    public void setS(Stats s) {
        this.s = s;
    } // end of setS()
    
    
    // Annnnd an overwritten toString() method
    @Override
    public String toString() {
        String s = "";
        s += String.format("\nName: " + getName());
        s += String.format ("\nTeam: " + getTeam());
        s += String.format ("\nUniverse: " + getUniverse());
        s += String.format ("\nHome Planet: " + getHomePlanet());
        s += String.format ("\nStats: " + getS());

        
        return s;
    } // end of toString()
    
    
    
} // end of Character class
