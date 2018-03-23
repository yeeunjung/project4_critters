package assignment4;
/* CRITTERS Main.java
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


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        String tempCommand;
        
        while(true) {
	        	System.out.println("critters>");
	        	tempCommand = kb.nextLine();  
	        	String[] tempCommandStr = tempCommand.trim().split(" ");
	        	if(tempCommandStr[0].equals("show")) {
	        		//if there's extra stuff after "show"
	        		if (tempCommandStr.length != 1)	{
	        			System.out.println("error processing: " + tempCommand);
	        		} else {
	        			Critter.displayWorld();
	        		}
	        	} else if(tempCommandStr[0].equals("step")) {
	        		if(tempCommandStr.length==1) {
	        			Critter.worldTimeStep();
	        		} else if (tempCommandStr.length==2){	
	        			try {
		        			for(int count=0; count<Integer.valueOf(tempCommandStr[1]); count++) {
		        				Critter.worldTimeStep();
		        			} 
	        			}	catch (NumberFormatException e)	{
	        					System.out.println("error processing: " + tempCommand);
		        			}
	        		} else {
	        			System.out.println("error processing: " + tempCommand);
	        		}
	        	} else if (tempCommandStr[0].equals("make")) {
	        		//if the command is "make" and nothing else or has more than three arguments
	        		if (tempCommandStr.length == 1 || tempCommandStr.length > 3)	{
	        			System.out.println("error processing: " + tempCommand);
	        		} else {
		        		int count = 1;
		        		if (tempCommandStr.length==3) {
		        			try {
		        				count = Integer.valueOf(tempCommandStr[2]);
		        			} catch (NumberFormatException e){
		        				System.out.println("error processing: " + tempCommand);
		        			}
		        		}
	        			try {
	        				for (int i=0; i<count; i++) {
	        					Critter.makeCritter(tempCommandStr[1]);
	        				}
	        			} catch(InvalidCritterException e) {
	        				System.out.println("error processing: " + tempCommand);
	        			}
	        		}
	        	} else if(tempCommandStr[0].equals("seed")){
	        		//if there isn't the correct number of arguments
	        		if (tempCommandStr.length != 2)	{
	        			System.out.println("error processing: " + tempCommand);
	        		} else {
		        		try {
		        			int seed = Integer.valueOf(tempCommandStr[1]);
		        			Critter.setSeed(seed);
		        		} catch (NumberFormatException e) {
		        			System.out.println("error processing: " + tempCommand);
		        		}
	        		}
	        	} else if(tempCommandStr[0].equals("stats")) {
	        		//if there isn't the correct number of arguments
	        		if (tempCommandStr.length != 2)	{
	        			System.out.println("error processing: " + tempCommand);
	        		} else {
		        		try {
		        			List<Critter> instances = Critter.getInstances(tempCommandStr[1]);
		        			Class StatCritter = Class.forName("assignment4." + tempCommandStr[1]);
		        			Method runStats = StatCritter.getMethod("runStats", List.class);
		        			runStats.invoke(StatCritter, instances);
		        			//Critter.runStats(instances);
		        		} catch (InvalidCritterException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | NoClassDefFoundError | IllegalArgumentException | InvocationTargetException e) {
		        			System.out.println("error processing: " + tempCommand);
		        		}
	        		}
	        	} else if(tempCommandStr[0].equals("quit")) {
	        		System.out.println("noob");
	        		break;
	        	} else {
	        		System.out.println("invalid command: " + tempCommand);
	        	}
        }

        // System.out.println("GLHF");
        
        /* Write your code above */
        System.out.flush();

    }
}
