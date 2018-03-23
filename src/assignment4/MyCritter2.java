package assignment4;

//import java.util.*;

//Moving diagonally makes this critter aggressive and ready to fight. Moving horizontally or vertically
//makes this critter clumsy, so each time it moves in such a way it falls and gets a new bruise and cut.
//

public class MyCritter2 extends Critter{
	
	private int dir = Critter.getRandomInt(3);
	private static int bruises = 0;
	private static int cuts = 0;
	private int injury = Critter.getRandomInt(2);
	
	@Override
	public void doTimeStep()
	{
		run(dir);
		if(dir==0 || dir==2) {
			bruises++;
			cuts++;
		}
	}
	
	@Override
	public boolean fight(String opponent) {
		//if the critter moved diagonally, it's FIGHT NIGHT
		if (dir == 1)	{
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return("2");
	}
	
	public static void runStats(java.util.List<Critter> critters)	{
		System.out.println("Total MyCritter2s: " + critters.size());
		System.out.println("Total bruises: " + bruises);
		System.out.println("Total cuts: " + cuts);
	}
}
