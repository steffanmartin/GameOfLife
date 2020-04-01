import java.util.*;
public class GOL {
	private int[][] board; // 0 = dead; 1 = alive
    private int[][] boardAlt; // the alternate board
    //private int random; 
    private int n;
    private int animationDelay; // millisecond delay for animation.
    
    // create a blank board of specified dimension.
    public GOL(int n, int delay)
    {
        this.n = n;
        board = new int[n][n];
        boardAlt = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
            	if (Math.random() > 0.9) {
            		board[i][j] = 1;
            	}else {
                	board[i][j] = 0;
                	}
            }
        }
        StdDraw.setXscale(-.5, n-.5);
        StdDraw.setYscale(-.5, n-.5);
        this.animationDelay = delay;
        StdDraw.show(animationDelay);
    }
    
    // create a board from the given matrix.
    public GOL(int[][] start, int delay) {
    
        this.n = start.length;
        board = new int[n][n];
        boardAlt = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++) board[i][j] = start[i][j];
        }
        StdDraw.setXscale(-.5, n-.5);
        StdDraw.setYscale(-.5, n-.5);
        this.animationDelay = delay;
        StdDraw.show(animationDelay);
    }
    
    
    public void step(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int iB = i-1, iA = i+1, jB = j-1, jA = j+1;
                if (i == 0) iB = n - 1;
                if (i == n-1) iA = 0;
                if (j == 0) jB = n - 1;
                if (j == n-1) jA = 0;
                int sum = board[iA][jA] + board[iA][j] + board[iA][jB]
                    + board[i][jA] + board[i][jB]
                    + board[iB][jA] + board[iB][j] + board[iB][jB];
                
                if ((board[i][j] == 1 && sum == 2) || sum == 3)
                    boardAlt[i][j] = 1;
                else boardAlt[i][j] = 0; 
            }
        }  
        int[][] a = board;
        board = boardAlt;
        boardAlt = a;
    }
    
    /*public int livingNeighbours(int x, int y, int[][] state) {
		int count = 0; 
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(i == 0 && j == 0)) {
					if (state[x+i][y+j] == 1) {
						count++;
					}
				}
			}
		}
		return count; 
	}
    
    public void step() {
    	for (int i=0; i < n; i++) {
    		for (int j=0; j < n; j++) {
    			if (board[i][j] == 1 && (this.livingNeighbours(i,j,board) < 2 
						|| this.livingNeighbours(i,j,board) > 3)) {
					boardAlt[i][j] = 0;
				} else if (board[i][j] == 1 && (this.livingNeighbours(i,j,board) == 2
						|| this.livingNeighbours(i,j,board) == 3)) {
					boardAlt[i][j] = 1;
				} else if (board[i][j] == 0 && this.livingNeighbours(i,j,board) == 3) {
					boardAlt[i][j] = 1;
				} else {
					boardAlt[i][j] = board[i][j];
				}
			}
		}
    	int[][] a = board;
        board = boardAlt;
        boardAlt = a;
    }*/
    
    public void show(){
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(n/2 - .5, n/2 - .5, n/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 1) {
                    StdDraw.filledSquare(j, n - 1 - i, .5);
                }
            }
        }
        StdDraw.show(animationDelay);
    }
}

