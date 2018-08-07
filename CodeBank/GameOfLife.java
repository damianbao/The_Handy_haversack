/**
 *  Description: after each iteration of the program life or death status 
 *  is reassigned to members of group based on encoed stipulations. The program 
 *  will perform this as many times as instructed.
 *  Author:  Brad Staier
 *  Due Date: 7/31/18
 *  Pledged: I pledge that I have upheld the Non-Collaboration Policy.
 *
 */
/** ********************************************************************
 * Revision History
 **********************************************************************
 * 2018 - Valerie Green - Text-only version for CSCI 110 Summer 2018
 * 2014 - Anne Applin - Re-written in Java using AWT
 * 2005 - Sharon Stansfield written in Borland C++ for CS1 at Ithaca
 *        College
 ******************************************************************** */

// Please try doing this project in NetBeans.
// However, if you are still using JEdit, you will need to remove the
// following line in order to build and run successfully from the
// command line. --vgreen
package gameoflife;


/**
 * A class to simulate the game of life which also, incidentally, prints
 * Sierpinski's Triangle fractal on the Canvas.
 *
 * @author aapplin and bstaier (TO DO: your name here...)
 */

import java.util.Arrays;
import java.util.Scanner;

public class GameOfLife {

    /**
     * printArray converts the boolean to a string and prints it
     * @param array is the array to be converted
     */

    public static void printArray(boolean[] array){
	System.out.println("Array: " + Arrays.toString(array));
    	System.out.println();
    	System.out.flush();
    }
    
     /**
     * fillArray ensures that the given array has the correct boolean values     *
     * @param array the array to be set with correct values
     */

    public static void fillArray(boolean[] array){
    	for (int i = 0; i<array.length; i++) {
    		if (i==5) { 
    			array[i] = true;
    		}else {
    			array[i] = false;
    		}
    	}    	
    }

     /**
     * gameTime runs the game of life simulation on the given array of any size for 
     *		any given amount of times
     *@param roster is the array that serves as the list of the various players in the game
     * @param generations refers to the number of times the game will be simulated on the given roster
     */

    public static void gameTime(boolean[] roster, int generations) {                
	int beforeNeighbor = 0;
        int afterNeighbor = 0; 
        boolean[] change = new boolean[roster.length];
        fillArray(change);
        
        for (int j=0; j<generations; j++ ){
        
        for (int i=0; i<roster.length; i++ ){
           beforeNeighbor = i - 1;
           afterNeighbor = i + 1;
           if (i == roster.length-1) {
           afterNeighbor = 0; 
           }
           if (i == 0) {
           beforeNeighbor = roster.length - 1; 
           }

            if (roster[i]==true) {
                if(roster[beforeNeighbor]==roster[afterNeighbor]) {
                    continue;
                }
                if (roster[beforeNeighbor]==true || roster[afterNeighbor]==true) {
                    change[i] = false;                                         	
                } 
                else {continue;}
            }  
            if (roster[i]==false) {
                if (roster[beforeNeighbor]==true ||roster[afterNeighbor]==true) {
                        change[i] = true;                        
                } 
                continue;
            } 
        }
        System.out.printf("Generation %d ", (j+1));
        printArray(roster);
        roster = change.clone();}
        }
    
    /**
     * main
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
         final int WORLD_SIZE = 10;
         final int GENERATIONS = 10;
        // Here we create the world, an arry of true/false values.
        // true means "alive" and false means "not alive".
        boolean[] world = new boolean[WORLD_SIZE];
       
        
       	fillArray(world);
        
        
        gameTime(world, GENERATIONS);
        
        
        
        
    
    }
    
    

    
    

}
        