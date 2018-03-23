package assignment4;

//import java.util.*;

//Moving diagonally makes this critter aggressive and ready to fight.

public class MyCritter2 extends Critter{
	
	int dir = Critter.getRandomInt(3);
	
	@Override
	public void doTimeStep()
	{
		run(dir);
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
		
	}
}
