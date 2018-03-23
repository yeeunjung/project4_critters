package assignment4;

/* CRITTERS Critter4.java
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
 * This critter is a mario-type character. This creature only walks straight left to right or vice versalike
 * a 2-D platform character would. It reverses its directions when meeting an enemy.
 * Stats: The critter collects coins randomly on its journey.
 */
import java.util.*;

public class Critter4 extends Critter {
	private static int coins = 0;
	private int dir = 0;

	@Override
	public void doTimeStep() {
		coins += Critter.getRandomInt(101);
		walk(dir);
	}

	@Override
	public boolean fight(String opponent) {
		if (dir == 0) {
			dir = 2;
		} else {
			dir = 0;
		}
		if (coins >= 0) {
			return true;
		}
		return false;
	}

	public String toString() {
		if (getEnergy() <= Params.start_energy * 0.5) {
			return "m";
		}
		return "M";
	}

	public static void runStats(java.util.List<Critter> critter4s) {
		System.out.println("The Critter has " + coins + "to spend.");
		int choice = Critter.getRandomInt(5);
		String chosen;
		switch(choice) {
			case 0:
				chosen = "choco milk";
				break;
			case 1:
				chosen = "strawberry cake";
				break;
			case 2: 
				chosen = "melon pan";
				break;
			case 3:
				chosen = "milk bread";
				break;
			case 4:
				chosen = "apple";
				break;
		}
		System.out.println("The Critter chooses the " + chosen + ".");
		coins -= 500;
		if(coins<0) {
			System.out.println("The Critter now has a debt of " + coins + " to the sharks.");
		} else {
			System.out.println("The Critter now has " + coins + " left.");
		}
	}

}