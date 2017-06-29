import java.util.Scanner;

/**
 * @author  Colin Casey
 * @version 1.0
 * This Class runs the console based UI.
 */
public class Main {

	/**
	 * Used to call console based UI method.
	 * @param args
	 */
    public static void main(String... args) {
    	console();
    }
    
    /**
     * This method handles the console based UI
     */
    public static void console() {
    	Scanner user = new Scanner(System.in);
    	boolean flag = true;
    	int path = 0;
    	while(flag) {
    		if(path == 0) {
    			System.out.println("Type in the number of your choice");
    			System.out.println("1 Print off table");
    			System.out.println("2 Update");
    			System.out.println("3 Exit");
    			path = user.nextInt();
    		} if(path == 1) {
    			
    		} if(path == 2) {
    			
    		} if(path == 3) {
    			flag = false;
    			path = 0;
    		} else {
    			path = 0;
    		}
    	}
    	user.close();
    }

    
}