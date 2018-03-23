package assignment4;

import java.util.ArrayList;
import java.util.List;

//This critter can walk in any direction and never chooses to fight. This critter's also very lucky, and
//each turn it wins a little bit of money from a lottery ticket (up to $1000). runStats prints the total
//money won as well as the individual amounts won each time step.

public class MyCritter5 extends Critter{
	
	private static int totalMoneyWon = 0;
	private static ArrayList<Integer> tickets = new ArrayList<Integer>();
	
	
	@Override
	public void doTimeStep()
	{
		int dir = Critter.getRandomInt(8);
		walk(dir);
		int lottoMoney = Critter.getRandomInt(1001);
		tickets.add(lottoMoney);
		totalMoneyWon += lottoMoney;
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
		System.out.println("Total MyCritter5s: " + critters.size());
		System.out.println("Total lottery money won: $" + totalMoneyWon);
		for(int i=1; i<tickets.size()+1; i++)	{
			System.out.println("Lottery ticket " + i + ": $" + tickets.get(i-1) + " won.");
		}
	}
}