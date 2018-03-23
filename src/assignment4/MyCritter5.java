package assignment4;

//description of critter goes here

public class MyCritter5 extends Critter{
	
	
	@Override
	public void doTimeStep()
	{
		int dir = Critter.getRandomInt(8);
		walk(dir);
	}
	
	@Override
	public boolean fight(String opponent) {
		//This critter's a goddang pacifist
		return false;
		
	}
	
	public String toString() {
		return("5");
	}
	
	public static void runStats(java.util.List<Critter> critters)	{
		
	}
}