import java.util.*;
public class Stats {
    // FIRST we need to declare our data members
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;
    
    
    
    // Cool beans. Now we can create our needed constructors

    public Stats() {
        
    } // End of no-arg constructor

    public Stats(int intelligence, int strength, int stamina, int speed, int skills) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
    } // End of Stats constructor
    
    // NICE, now for getters and setters

    public int getIntelligence() {
        return intelligence;
    } // end of getIntelligence()

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    } // end of setIntelligence()

    public int getStrength() {
        return strength;
    } // end of getStrength()

    public void setStrength(int strength) {
        this.strength = strength;
    } // end of setStrength()

    public int getStamina() {
        return stamina;
    } // end of getStamina()

    public void setStamina(int stamina) {
        this.stamina = stamina;
    } // end of setStamina()

    public int getSpeed() {
        return speed;
    } // end of getSpeed()

    public void setSpeed(int speed) {
        this.speed = speed;
    } //end of setSpeed()

    public int getSkills() {
        return skills;
    } // end of getSkills()

    public void setSkills(int skills) {
        this.skills = skills;
    } // end of setSkills()
    
    // And now, for an overwritten toString() method

    @Override
    public String toString() {
        String s = "";
        s += String.format("\nIntelligence: " + getIntelligence());
        s += String.format("\nStrength: " + getStrength());
        s += String.format ("\nStamina: " + getStamina());
        s += String.format ("\nSpeed: " + getSpeed());
        s += String.format ("\nSkills: " + getSkills());
        return s;
    } // end of toString()
    
    // We need a method to calculate a character's total attack power based 
    // off of their stats
    // This will help us with the FIGHT Command
    
    public int calcStatAttackPower(){
        int totalAttack = 0;
        // We'll simply add all of the stats, then return the total
        totalAttack += getIntelligence();
        totalAttack += getStrength();
        totalAttack += getStamina();
        totalAttack += getSpeed();
        totalAttack += getSkills();
        return totalAttack;
        // cool beans, we're done.
        
    } // END of calcStatAttackPower()
    
 
                
    
} // END of Stats class
