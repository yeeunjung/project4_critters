package assignment4;

/*
 * Just for fun. Not part of the 4.
 */
import assignment4.Critter.TestCritter;

public class Critter5 extends TestCritter {

	public String toString() { return "*"; }
	
	public boolean fight(String not_used) { return true; }
	
	public void doTimeStep() {
		setEnergy(getEnergy() + Params.photosynthesis_energy_amount);
	}
}
