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

	/**
	 * Initializes the data for the router table
	 * @author Bryce
	 */
	public void initData() {

		Router router1 = new Router("Office Router", "10.10.0.1");
		Router router2 = new Router("Bedroom Router", "10.10.0.2");
		Router router3 = new Router("Basement Router", "10.10.0.3");
		Router router4 = new Router("Loft Router", "10.10.0.4");
		Device device0 = new Device("Office Device1", "192.68.0.1");
		Device device1 = new Device("Office Device2", "192.68.0.2");
		Device device2 = new Device("Bedroom Device1", "192.68.0.1");
		Device device3 = new Device("Bedroom Device2", "192.68.0.2");
		Device device4 = new Device("Basement Device1", "192.68.0.1");
		Device device5 = new Device("Basement Device2", "192.68.0.2");
		Device device6 = new Device("Loft Device1", "192.68.0.1");
		Device device7 = new Device("Loft Device2", "192.68.0.2");
	}
    
}