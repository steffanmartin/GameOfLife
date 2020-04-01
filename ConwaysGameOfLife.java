import java.io.*;
import java.util.*;

public class ConwaysGameOfLife {

	//private final static int mapSize = 40;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner console = new Scanner(System.in);
    	System.out.println("Load Map or Random Map?\n1 - Load Map\n2 - Random Map");
    	System.out.print("Choice: ");
    	int c = console.nextInt();
		
		//DrawMap(mapSize);
		
		if (c == 1) {
			GameOfLife(FileReader());
			}
		if (c == 2) {
			System.out.println("Mapsize?");
	    	System.out.print("Choice: ");
	    	int mapSize = console.nextInt();	
	    	System.out.println("Seed, ]0;1[ ?");
	    	System.out.print("Choice: ");
	    	double seed = console.nextDouble();
	    	
	    	DrawMap(mapSize);
			GameOfLife(seed, mapSize);
		}
		
	}

	public static void DrawMap (int mapSize) {
		
		StdDraw.setXscale(-1, mapSize + 1);
        StdDraw.setYscale(-(mapSize+1), 1);
		
        
        //StdDraw.setPenColor(StdDraw.GRAY);
        //StdDraw.filledSquare(0, 0, mapSize);
        
        StdDraw.setPenColor(StdDraw.GRAY);	//Gitter
        StdDraw.setPenRadius(5.0/1000);
        for (int i= 0; i < mapSize; i++) {
        	 StdDraw.line(0, -i, mapSize, -i);
        	 StdDraw.line(i, 0, i, -mapSize);
        }
        
        //StdDraw.setPenColor(StdDraw.BLACK); //Kanter
        //StdDraw.setPenRadius(10.0/1000); 
        StdDraw.line(0, 0, mapSize, 0); 				//Top
        StdDraw.line(0, 0, 0, -mapSize); 				//Venstre
        StdDraw.line(0, -mapSize, mapSize, -mapSize);	//Bund
        StdDraw.line(mapSize, 0, mapSize, -mapSize);	//Højre
      
	}

	public static int[][] FileReader() throws FileNotFoundException {

			int[][] loadedMap = new int[4][4];
			Scanner input = new Scanner(new File("C:\\DATA\\toad.gol"));
			while(input.hasNextLine()) {						//https://www.tutorialspoint.com/How-to-read-a-2d-array-from-a-file-in-java
			for (int i = 0; i < loadedMap.length; i++) {
	            String[] line = input.nextLine().trim().split(" ");
	            for (int j = 0; j < line.length; j++) {
	               loadedMap[j][i] = Integer.parseInt(line[j]);	//[j][i] og ikke ij for at det vender rigtigt
	            }
	         }
	      }
	      System.out.println(Arrays.deepToString(loadedMap));
	      
	      return loadedMap;
	   }
	
	public static void GameOfLife(int[][] initialState) {
			
		StdDraw.setPenRadius((675.0/mapSize)/1000);				//Skalerer prikkerne
		StdDraw.setPenColor(StdDraw.RED);
		
		for (int i = 0; i < initialState.length; i++) {			//Tegner punkter hvor array har 1.
			for (int j = 0; j < initialState[i].length; j++) {
				if(initialState[i][j] == 1) {
					StdDraw.point(i,-j);
				}
			}
		}
	}
	public static void GameOfLife(double seed, int mapSize) {
		
		int[][] currentState = new int[mapSize+1][mapSize+1];
		
		StdDraw.setPenRadius((675.0/mapSize)/1000);		//Skalerer prikkerne
		StdDraw.setPenColor(StdDraw.RED);
		
		for (int i = 0; i <= mapSize; i++) {			//Tegner tilfældige punkter
			for (int j = 0; j <= mapSize; j++) {
				if(Math.random() >= seed) {
					
					currentState[i][j] = 1;
					StdDraw.point(i,-j);
				}
			}
		}
		
		
	}
}
