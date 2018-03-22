package assignment4;
/* CRITTERS Main.java
 * EE422C Project 4 submission by
 * Allegra Thomas
 * at35737
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


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
<<<<<<< HEAD
        
        
=======
        ArrayList<String> tempCommand = new ArrayList<String>();
        while(true) {
        	System.out.println("critters>");
        	tempCommand.add(kb.next());       	
        	if(tempCommand.get(0).equals("show")) {
        		Critter.displayWorld();
        	} else if(tempCommand.get(0).equals("step")) {
        		if(tempCommand.size()==1) {
        			Critter.worldTimeStep();
        		} else {
        			for(int count=0; count<Integer.valueOf(tempCommand.get(1)); count++) {
        				Critter.worldTimeStep();
        			}
        		}
        	} else if(tempCommand.get(0).equals("quit")) {
        		System.out.println("noob");
        		break;
        	} else {
        		System.out.println("noob");
        	}
        	tempCommand.clear();
        }
        // System.out.println("GLHF");
>>>>>>> 2be08f5281e573b6ad735d4c964ec4cc579b3fca
        
        /* Write your code above */
        System.out.flush();

    }
}
