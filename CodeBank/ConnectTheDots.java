/**
 *  Description: a program to read a series of coordinates from the data file coords.txt (included
 *  with this project). Use each coordinate to draw a dot on the canvas. Then draw a line
 *  between each dot and the next dot.
 *  Author:  Brad Staier
 *  Due Date: 08/07/1984
 *  Pledged: I pledge that I have upheld the Non-Collaboration Policy.
 *
 */
 
// add appropriate import statements here.
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.awt.Point;
// These imports you can leave as is.
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
 /**
  @author  Brad Staier
 */
 
 public class ConnectTheDots extends Application {
 	 
 	/*
 	 * Do not add code to main().  Add it below in connectTheDots instead.
 	*/
 	public static void main(String[] args) {
 		launch(args);
 	}
 	
 	/*
 	 * You do not have to change any of the code in this "start" method.
 	*/
 	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connect the Dots");
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 840);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        connectTheDots(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    /**
     * reads a file of coordinates and stores them in an array of points
     * @param inFile the file to be read
     * @param array the array used to store the points
     * @return numPoints the number of points stored.
    */

    public static int processFile(String inFile, Point[] array) {
       int numPoints = 0;
        try {
            // open the output file for writing
            //PrintWriter fWriter = new PrintWriter(outFile);
            // open the input file for reading
            FileReader fReader = new FileReader(inFile);
            // attach a Scanner and continue to read words until
            // the end of the file.
            Scanner scan = new Scanner (fReader);
            while (scan.hasNext()) { 
                for (int i=0; i<400; i++) {
                    Point coordinates = new Point(0,0);
                    int x = coordinates.x;
                    int y = coordinates.y;

                    coordinates.x = scan.nextInt(); // get the next number
                    coordinates.y = scan.nextInt();
                    array[i] = coordinates;                       
                    numPoints ++;
                }
                
            }

            // We're done.  close the files.
            
            fReader.close();

        } catch (IOException e) {
            // if an error happened opening or reading from the file,
            // we'll end up here.  Print the error message.
            System.out.println(e.getMessage());
        } 
        System.out.println("Array Length: " + numPoints);
        return numPoints;  
    }
     
     
    // TODO: method to do the File I/O.  See Section 3 of the project handout
    // for details about the method signature.
    

    /*
     * Pretend this is your main method.  All of your code
     * should go in here, including your array.  Call methods as necessary.
     * You will write one separate method to read from the data file.
    */
     private void connectTheDots(GraphicsContext gc) {
        
        final String fName = "coords.txt";
        int arraySize = -1;
     	gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
     	final int DOT_DIAM = 8;
     	final int MAX_DOTS = 500; // use this for the size of your Point array
     	
     	// here is where you will create your array, 
     	Point[] coordinates = new Point[MAX_DOTS];

        // and call your method to read in the data file.

     	arraySize = processFile(fName, coordinates);

     	for (int i=0; i<arraySize; i++){
            gc.fillOval(coordinates[i].x, coordinates[i].y, DOT_DIAM, DOT_DIAM);
         	// draw a line from (30,80) to (100,200)
            if ( i<arraySize -1){
         	  gc.strokeLine(coordinates[i].x,coordinates[i].y,coordinates[i+1].x,coordinates[i+1].y);
            }
        }
    }
 }