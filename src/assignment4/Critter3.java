package assignment4;
/* CRITTERS Critter3.java
 * EE422C Project 4 submission by
 * Allegra Thomas
 * at35737
 * 15510
 * Yeeun Jung
 * yj3897
 * 15510
 * Slip days used: <0>
 * Spring 2018
 */
/*
 * This critter is a shy Critter at a party. It always moves in a diagonal direction (3).
 * This Critter only fights back when truly threatened. 
 * Otherwise, it will always run away or walk away, depending on the energy needed.
 * The stats for this Critter will reflect what it did in a fight, or essentially an encounter
 * with another Critter. This Critter will refuse eye contact (walk away), smash face into a corner (run away), or
 * be trapped by other people and feel stressed (fight).
 */
import java.util.*;

public class Critter3 extends Critter {
	private static int numTimesStressed = 0;
	private static int numTimesEyeContact = 0;
	private static int numTimesSmashed = 0;
	
	@Override
	public void doTimeStep() {
		walk(3);
	}

	@Override
	public boolean fight(String opponent) {
		if (getEnergy() > Params.run_energy_cost+Params.rest_energy_cost*3) { 
			run(3);
			numTimesSmashed++;
			return false;
		} else if(getEnergy() > Params.walk_energy_cost+Params.rest_energy_cost*3) {
			walk(3);
			numTimesEyeContact++;
			return false;
		} else {
			numTimesStressed++;
			return true;
		}
	}
	
	public String toString() {
		return "#";
	}
	
	public static void runStats(java.util.List<Critter> critters3) {
		System.out.println("This Critter hates parties. Let's review how it copes being in a party situation.");
		System.out.println("This Critter refused eye contact " + numTimesEyeContact + " times.");
		System.out.println("This Critter smashed its face into a corner " + numTimesSmashed + " times.");
		System.out.println("This Critter was cornered by other Critters " + numTimesStressed + " times.");
		if(numTimesStressed + numTimesSmashed+numTimesEyeContact==0) {
			numTimesStressed = 1; // picked arbitrary -> will be zero.
		}
		int percentageSuccess = (numTimesSmashed+numTimesEyeContact)/(numTimesStressed + numTimesSmashed+numTimesEyeContact)*100;
		System.out.println("Engagement was successfully avoided " + percentageSuccess + "% of the time.");
	}
	
}