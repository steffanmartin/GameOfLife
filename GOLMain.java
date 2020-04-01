import java.util.Scanner;

public class GOLMain {
	public static void main(String[] args) {
    	Scanner c1 = new Scanner(System.in);
    	int n = c1.nextInt();
        GOL game = new GOL(n, 100);
        while (true)
        {
            game.show();
            game.step();
        }
    }

}
